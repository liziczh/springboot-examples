package com.liziczh.springboot.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.liziczh.springboot.aop.controller.TestController;
import com.liziczh.springboot.aop.service.TestService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootAopApplicationTests {

    @Autowired
    private TestController controller;

    @Autowired
    private TestService service;

    @Test
    public void controllerAop() {
        String hello = controller.hello();
        System.out.println(hello);
    }

    @Test
    public void serviceAop() {
        String hello = service.hello();
        System.out.println(hello);
    }
}
