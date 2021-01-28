package com.blibli.belajar.design.patterns.dynamicmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

public class DynamicModuleApplication {

    @SpringBootApplication
    public static class Application {

    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class);
    }
}
