package com.example.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(BeanConfig.class);

        ShoppingCart shoppingCart = context.getBean(ShoppingCart.class);
        shoppingCart.cart("Processing...");
        shoppingCart.getQuantity();
    }
}