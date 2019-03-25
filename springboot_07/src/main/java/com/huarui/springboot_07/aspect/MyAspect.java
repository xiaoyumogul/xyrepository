package com.huarui.springboot_07.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @ Author       : 肖宇
 * @ Date         : Created in 9:26 2019/3/18
 * @ Description  :
 */
@Aspect
@Component
public class MyAspect {
    @Before("execution(public  *  com.huarui.springboot_07.controller.GirlController.*(..))")
    public void doBefore(){
        System.out.println("**************");
    }
}
