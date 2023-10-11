package com.eagle.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author eagle
 * @Date 2023/8/11 14:11
 * @DescribeGlobalExceptionHandler
 */
@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(LoginException.class)
    public void handleGlobalException(Exception s, HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.sendRedirect("/");
    }

}
