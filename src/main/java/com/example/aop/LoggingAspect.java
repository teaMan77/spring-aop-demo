package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.aop.ShoppingCart.cart(..))")
    public void beforeLogger() {
        System.out.println("Before Logger");
    }

    @After("execution(* com.example.aop.*.cart(..))")
    public void afterLogger() {
        System.out.println("After Logger");
    }

    @AfterReturning("execution(* com.example.aop.ShoppingCart.cart(..))")
    public void statusLogger(JoinPoint joinPoint) {
//        System.out.println(joinPoint.getSignature());
        String status = joinPoint.getArgs()[0].toString();
        System.out.println("Your order is: " + status);
    }

    @Pointcut("execution(* com.example.aop.ShoppingCart.getQuantity())")
    public void afterReturningPointcut() {
    }

    @AfterReturning(pointcut = "afterReturningPointcut()", returning = "returnValue")
    public void afterReturning(int returnValue) {
        System.out.println("Quantity Remaining: " + returnValue);
    }





}
