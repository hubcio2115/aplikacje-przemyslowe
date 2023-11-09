package com.example.zad2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.util.stream.Stream;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class Zad2Application {
  public static void main(String[] args) {
    var context = SpringApplication.run(Zad2Application.class, args);

    Stream.of(context.getBeanDefinitionNames()).map(context::getBean).forEach(System.out::println);
  }
}
