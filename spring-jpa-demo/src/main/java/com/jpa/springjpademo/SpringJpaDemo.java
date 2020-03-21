package com.jpa.springjpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringJpaDemo {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaDemo.class, args);
    }
}
