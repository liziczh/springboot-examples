package com.liziczh.springboot.aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect
public class AppServiceAop {
    /**
     * 切入点
     */
    @Pointcut("@annotation(com.liziczh.springboot.aop.annotation.AppService)")
    public void appService() {
    }

    /**
     * 前置通知
     *
     * @param joinPoint 切点
     */
    @Before("appService()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("========================================== doBefore ======================================");
    }

    /**
     * 环绕通知
     *
     * @param proceedingJoinPoint 切入点
     * @return
     * @throws Throwable
     */
    @Around("appService()")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        // 开始打印请求日志
        log.info("========================================== Service Start ==========================================");
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}", proceedingJoinPoint.getSignature().getDeclaringTypeName(),
                proceedingJoinPoint.getSignature().getName());
        // 打印请求入参
        String methodParams = null;
        Object[] args = proceedingJoinPoint.getArgs();
        if (args != null && args.length > 0) {
            methodParams = Arrays.toString(args);
        }
        log.info("Request Args   : {}", methodParams);
        // 执行方法
        Object result = proceedingJoinPoint.proceed();
        // 打印出参
        log.info("BaseResponse Args  : {}", result);
        // 执行耗时
        log.info("Time-Consuming : {} ms", System.currentTimeMillis() - startTime);
        // 接口结束后换行，方便分割查看
        log.info("=========================================== Service End ===========================================");
        return result;
    }

    @After("appService()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("========================================== doAfter ======================================");
    }

    /**
     * 返回通知
     *
     * @param joinPoint   切点
     * @param returnValue 返回值
     */
    @AfterReturning(value = "appService()", returning = "returnValue")
    public void doAfterReturningAdvice(JoinPoint joinPoint, Object returnValue) {
        // 打印调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
        // 打印方法返回值
        log.info("Return Value   : {}", returnValue);
        // 接口返回结束
        log.info("========================================= Service Return =========================================");
    }

    @AfterThrowing(value = "appService()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("Service Exception", e);
    }
}
