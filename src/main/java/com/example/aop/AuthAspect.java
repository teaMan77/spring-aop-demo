package com.example.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthAspect {
    //in this scenario the user is authenticated before the requests enters any package inside com.example.aop
    //and then the user is authorised before the request reaches the ShoppingCart class.

    //make the point cut before certain packages
    @Pointcut("within(com.example.aop.*)")
    public void authentication() {
    }

    //or make the point cut before certain classes
    @Pointcut("within(com.example.aop.ShoppingCart)")
    public void authorization() {
    }

    //then call those point cuts before the execution of those packages or classes.
    @Before("authentication() && authorization()")
    public void auth() {
        System.out.println("User Authenticated Successfully");
    }
}
