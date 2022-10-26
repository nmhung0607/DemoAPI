package com.example.demo;

import com.example.demo.configuration.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;

@Import({JpaConfiguration.class})
@SpringBootApplication(scanBasePackages = {"com.example.demo"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableCaching // Enable Caching
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
