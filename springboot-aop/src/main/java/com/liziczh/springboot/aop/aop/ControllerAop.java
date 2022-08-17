package com.liziczh.springboot.aop.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class ControllerAop {

    @Pointcut("execution(public * com.liziczh..*.controller.*.*(..))")
    public void webController() {
        log.info("========================================== Web Controller ======================================");
    }

    /**
     * 前置通知
     *
     * @param joinPoint
     * @return void
     * @author chenzhehao
     * @date 2022/1/16 8:34 下午
     */
    @Before("webController()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("========================================== doBefore ======================================");
    }

    /**
     * 环绕通知
     *
     * @param joinPoint 切点
     * @return result
     * @throws Throwable
     */
    @Around("webController()")
    public Object doAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        // 打印请求相关参数
        log.info("========================================== Around Start ==========================================");
        // 打印请求 url
        log.info("URL            : {}", request.getRequestURL().toString());
        // 打印 Http method
        log.info("HTTP Method    : {}", request.getMethod());
        // 打印请求的 IP
        log.info("IP             : {}", request.getRemoteAddr());
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
        // 打印请求入参
        String methodParams = null;
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            methodParams = Arrays.toString(args);
        }
        log.info("Request Args   : {}", methodParams);
        // 执行方法
        Object result = joinPoint.proceed();
        // 打印出参
        log.info("BaseResponse Args  : {}", result);
        // 执行耗时
        log.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        // 接口结束
        log.info("=========================================== Around End ===========================================");
        return result;
    }

    /**
     * 后置通知
     */
    @After("webController()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("========================================== doAfter ======================================");
    }

    /**
     * 返回通知
     *
     * @param joinPoint   切点
     * @param returnValue 返回值
     */
    @AfterReturning(value = "webController()", returning = "returnValue")
    public void doAfterReturningAdvice(JoinPoint joinPoint, Object returnValue) {
        // WebLogIgnore
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
        // 打印方法返回值
        log.info("Return Value   : {}", returnValue);
        // 接口返回
        log.info("========================================= Return ========================================={}",
                System.lineSeparator());
    }

    @AfterThrowing(value = "webController()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("Web Exception", e);
    }
}
