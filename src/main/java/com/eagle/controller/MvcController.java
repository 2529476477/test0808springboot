package com.eagle.controller;

import com.eagle.anno.IgnoreLog;
import com.eagle.anno.Log;
import com.eagle.pojo.Dept;
import com.eagle.pojo.Emp;
import com.eagle.service.DeptService;
import com.eagle.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author eagle
 * @Date 2023/8/9 17:29
 * @DescribeMvcController
 */
@Controller
public class MvcController {

    @Autowired
    private EmpService empService;
    @Autowired
    private DeptService deptService;

    @IgnoreLog
    @RequestMapping("/")
    public String index(){

        return "/login.html";
    }

    @Log
    @RequestMapping("/save")
    public String save(Model model){
        List<Dept> deptList = deptService.list();

        model.addAttribute("deptList",deptList);
        return "/addEmp.html";
    }

    @Log
    @GetMapping("/{empno}")
    public String updateEmp(Model model,@PathVariable("empno") Integer empno){
        List<Dept> deptList = deptService.list();
        Emp emp = empService.getById(empno);

        model.addAttribute("deptList",deptList);
        model.addAttribute("empInfo",emp);

        return "/updateEmp.html";
    }

   /* @DeleteMapping("/emps")
    public String deleteAll(String[] emps, HttpSession session){

        System.out.println(emps);
        List list = Arrays.asList(emps);
        System.out.println(list);
        boolean removeByIds = empService.removeByIds(list);
        if (!removeByIds){
            session.setAttribute("msg","删除失败");
        }
        return "redirect:/emp/main";
    }*/
}
