package com.liziczh.springboot.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.liziczh.springboot.web.interceptor.Test1Interceptor;
import com.liziczh.springboot.web.interceptor.Test2Interceptor;

import lombok.extern.slf4j.Slf4j;

/**
 * common
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2023/6/30 11:36 AM
 */
@Slf4j
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private Test1Interceptor test1Interceptor;

    @Autowired
    private Test2Interceptor test2Interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(test1Interceptor).addPathPatterns("/**");
        registry.addInterceptor(test2Interceptor).addPathPatterns("/**");
    }

}
