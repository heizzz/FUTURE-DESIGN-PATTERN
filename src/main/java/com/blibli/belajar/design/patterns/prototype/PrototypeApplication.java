package com.blibli.belajar.design.patterns.prototype;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class PrototypeApplication {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Customer {
        private String id;
        private String name;
        private String category;
        private Integer discount;
    }

    @SpringBootApplication
    public static class Configuration{
        // kalo gapake prototype, ketika di getbeans dia cmn buat 1
        // kalo pake, dia bakal terus buat beans baru
        @Bean
        @Scope("prototype")
        public Customer standardCustomer(){
            return Customer.builder()
                    .category("STANDARD")
                    .discount(10)
                    .build();
        }
    }
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Configuration.class);
        Customer customerStandard1 = context.getBean(Customer.class);
        Customer customerStandard2 = context.getBean(Customer.class);
        Customer customerStandard3 = context.getBean(Customer.class);


        System.out.println(customerStandard1 == customerStandard2);
        System.out.println(customerStandard2 == customerStandard3);

        System.out.println(customerStandard1);
        System.out.println(customerStandard2);
        System.out.println(customerStandard3);
    }
}
