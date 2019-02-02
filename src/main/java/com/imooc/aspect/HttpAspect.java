package com.imooc.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * create by tyler on 2019/2/2 16:19,
 * reach me by tyler4400@foxmail.com
 */
@Aspect
@Component
public class HttpAspect {

    @Before("execution(public * com.imooc.Controller.GirlController.*(..))")
    public void beforeLog(){
        System.out.println(11111);
    }

    @After("execution(public * com.imooc.Controller.GirlController.*(..))")
    public void afterLog(){
        System.out.println(22222);
    }
}
