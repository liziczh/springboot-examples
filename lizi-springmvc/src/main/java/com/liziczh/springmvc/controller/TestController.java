package com.liziczh.springmvc.controller;

import com.liziczh.springmvc.annotation.MyController;
import com.liziczh.springmvc.annotation.MyRequestMapping;
import com.liziczh.springmvc.annotation.MyRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@MyController
@MyRequestMapping("/test")
public class TestController {

    @MyRequestMapping()
    public void test(HttpServletRequest request, HttpServletResponse response, @MyRequestParam("param") String param) {
        System.out.println(param);
        try {
            response.getWriter().write("doTest method success! param:" + param);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
