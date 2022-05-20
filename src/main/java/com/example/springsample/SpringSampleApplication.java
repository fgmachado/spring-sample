package com.example.springsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class SpringSampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringSampleApplication.class, args);
  }

}
