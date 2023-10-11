package com.eagle.aop;

import com.eagle.exception.LoginException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author eagle
 * @Date 2023/8/11 11:53
 * @DescribeMyAop
 */
@Aspect
@Component
public class MyAop {

    @Pointcut("@annotation(com.eagle.anno.Log)")
    public void pc(){}

    //@Before(value = "pc()")
    public void checkLogin() throws LoginException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        Object userInfo = session.getAttribute("userInfo");
        if (userInfo==null){
            throw new LoginException();
        }
        String id = session.getId();
        Cookie[] cookies = request.getCookies();
        Boolean flag=false;
        if (cookies==null){
            throw new LoginException();
        }
        for (Cookie coolie:cookies) {
            if (coolie.getValue().equals(id)){
                flag=true;
            }
        }
        if (flag){

        }else {
            throw new LoginException();
        }


    }
}
