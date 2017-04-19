package com.dai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class DemoApplication {

//    @RequestMapping("/")
//    String home() {
//        return "Hello World!";
//    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
