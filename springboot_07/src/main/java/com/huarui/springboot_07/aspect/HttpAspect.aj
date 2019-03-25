package com.huarui.springboot_152_5.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ Author       : 蒋亚平
 * @ Date         : Created in 15:00 2019/3/15
 * @ Description  :
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger=LoggerFactory.getLogger(HttpAspect.class);
    //切入点
    @Pointcut("execution(public * com.huarui.com.huarui.springboot_07.controller.GirlController.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={}",request.getRequestURL());
        logger.info("uri={}",request.getRequestURI());
        logger.error("error:模拟error");
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringType().getName()+"."+joinPoint.getSignature().getName());
    }

    @After("log()")
    public void doAfter(){
        logger.info("after.......");
    }

    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}
