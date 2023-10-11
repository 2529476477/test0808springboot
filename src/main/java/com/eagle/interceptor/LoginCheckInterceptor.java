package com.eagle.interceptor;

import com.eagle.anno.IgnoreLog;
import com.eagle.exception.LoginException;
import com.eagle.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @Author eagle
 * @Date 2023/8/11 15:20
 * @DescribeLoginCheckInterceptor
 */

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod) handler;
        Method method=handlerMethod.getMethod();

        if (method.isAnnotationPresent(IgnoreLog.class)){
            return true;
        }else {
            HttpSession session = request.getSession();
            User userInfo =(User)session.getAttribute("userInfo");
            String id = session.getId();
            Cookie[] cookies = request.getCookies();
            Boolean flag=false;
            if (cookies==null){
                response.sendRedirect("/");
                return false;
            }
            for (Cookie coolie:cookies) {
                if (coolie.getValue().equals(id)&&userInfo!=null){
                    flag=true;
                }
            }
            if (flag){
                return true;
            }else {
                response.sendRedirect("/");
                return false;
            }
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
