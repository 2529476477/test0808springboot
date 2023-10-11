package com.eagle.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eagle.anno.Log;
import com.eagle.pojo.Dept;
import com.eagle.pojo.Emp;
import com.eagle.pojo.User;
import com.eagle.service.DeptService;
import com.eagle.service.EmpService;
import com.eagle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * @Author eagle
 * @Date 2023/8/9 17:56
 * @DescribeEmpController
 */
@Log
@Controller
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private DeptService deptService;
    @Autowired
    private EmpService empService;



    @RequestMapping("/main")
    public String list(Model model){

       /* Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("userInfo")){

                System.out.println("userInfo:"+cookie.getValue());}

        }
        HttpSession session = request.getSession();
        User userInfo =(User)session.getAttribute("userInfo");*/


        List<Dept> deptList = deptService.list();
        List<Emp> empList = empService.list();

        model.addAttribute("empList",empList);
        model.addAttribute("deptList",deptList);
        return "main";
    }


    @GetMapping("/search")
    public String search(@RequestParam Integer deptno, @RequestParam String ename, Model model){
        List<Dept> deptList = deptService.list();
        QueryWrapper<Emp> empQueryWrapper = new QueryWrapper<>();
        String dname=null;
        if (deptno!=-1){
            QueryWrapper<Dept> deptQueryWrapper = new QueryWrapper<>();
            deptQueryWrapper.select("dname").eq("deptno",deptno);
            Dept dept = deptService.getOne(deptQueryWrapper);
            if (dept!=null){
                dname = dept.getDname();
            }
        }
        if (dname==null){
            empQueryWrapper.like("ename",ename);
        }else {
            empQueryWrapper.eq("dname",dname).like("ename",ename);
        }
        List<Emp> empList = empService.list(empQueryWrapper);
        model.addAttribute("empList",empList);
        model.addAttribute("deptList",deptList);
        return "main";

    }


    @PostMapping("/save")
    public String save(Emp emp,HttpSession session){
        System.out.println(emp);
        if (emp.getEname()!=null&&emp.getJob()!=null&&emp.getHiredate()!=null
                &&emp.getSal()!=null&&emp.getDname()!=null) {
            boolean save = empService.save(emp);
            if (save){
                return "redirect:/emp/main";
            }
        }
        session.setAttribute("msg","填写不正确");
        return "addEmp.html";
    }



    @PutMapping("/update")
    public String updateEmp(Emp emp,HttpSession session){
        System.out.println(emp);
        boolean update = empService.updateById(emp);
        if (update){
            return "redirect:/emp/main";
        }
        session.setAttribute("msg","填写不正确");
        return "updateEmp.html";
    }


    @DeleteMapping("/{empno}")
    public String deleteEmp(@PathVariable("empno") Integer empon,HttpSession session){
        boolean removeById = empService.removeById(empon);
        if (!removeById){
            session.setAttribute("msg","删除失败");
        }
        return "redirect:/emp/main";
    }


    @DeleteMapping ("/emps")
    public String deleteAll(String[] emps, HttpSession session){
        System.out.println(emps);
        List list = Arrays.asList(emps);
        System.out.println(list);
        boolean removeByIds = empService.removeByIds(list);
        if (!removeByIds){
            session.setAttribute("msg","删除失败");
        }
        return "redirect:/emp/main";
    }

}
