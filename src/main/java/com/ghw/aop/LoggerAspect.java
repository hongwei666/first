package com.ghw.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class LoggerAspect {

    //    @Before("execution(* com.ghw.service.UserService.*(..))")
    public void before() {
        System.out.println("前置通知");
    }

    //数据库连接日志记录
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Logger logger = Logger.getLogger(LoggerAspect.class);
        logger.info("开始连接数据库");
        Object object = proceedingJoinPoint.proceed();
        logger.info("数据库查询返回成功");
        return object;
    }

    public void after() {
        System.out.println("后置增强");
    }

    public void afterThrowing() {
        System.out.println("异常通知");
    }

    public void afterReturning() {
        System.out.println("返回通知");
    }
}
