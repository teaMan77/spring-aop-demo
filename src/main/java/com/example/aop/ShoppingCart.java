package com.example.aop;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

    public void cart() {
        //Logging -- aspect 1
        //Authentication and Authorisation -- aspect 2
        //Sanitise the data -- aspect 3
        System.out.println("Shopping cart is called");
    }
}
