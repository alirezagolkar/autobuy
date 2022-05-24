package com.dealers.autobuy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class AutobuyApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutobuyApplication.class, args);
    }

}