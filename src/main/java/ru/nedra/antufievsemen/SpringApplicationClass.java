package ru.nedra.antufievsemen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringApplicationClass {

    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationClass.class, args);
    }
}
