package com.crud.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Configuration
@ComponentScan("com.crud.crud.controllers")
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class CrudApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<CrudApplication> applicationClass = CrudApplication.class;
}


@RestController
class GreetingController {

    @RequestMapping("/hello/{name}")
    //@RequestMapping("/")
    String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
       //return "default";
    }
} 