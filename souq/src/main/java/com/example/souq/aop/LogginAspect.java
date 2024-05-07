package com.example.souq.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {

    Logger log = LoggerFactory.getLogger(LogginAspect.class);

    @Before("execution(* com.example.souq.Service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("LoggingAspect: Method {} is about to be executed.", joinPoint.getSignature());
    }
    @After("execution(* com.example.souq.Service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("LoggingAspect: Method {} is executed.", joinPoint.getSignature());
    }
    @Around("execution(* com.example.souq.Service.*.*(..))")
    public Object monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        log.info("PerformanceMonitoringAspect: Method {} executed in {} milliseconds", joinPoint.getSignature(), executionTime);
        return result;
    }

}
