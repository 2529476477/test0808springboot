package com.eagle.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.eagle.anno.IgnoreLog;
import com.eagle.pojo.User;
import com.eagle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author eagle
 * @Date 2023/8/9 17:29
 * @DescribeUserController
 */
@IgnoreLog
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @IgnoreLog
    @RequestMapping("/login")
    public String login(String username, String pwd, HttpSession session, HttpServletResponse response){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username).eq("pwd",pwd);
        User user = userService.getOne(wrapper);
        if (user!=null){
            session.setAttribute("userInfo",user);
            Cookie cookie = new Cookie("userInfo",user.getUsername()+":"+user.getPwd());
            cookie.setDomain("localhost");
            cookie.setPath("/");
            response.addCookie(cookie);
            return "redirect:/emp/main";
        }else {
            session.setAttribute("msg","user不正确");
            return "redirect:/";
        }

    }
}
