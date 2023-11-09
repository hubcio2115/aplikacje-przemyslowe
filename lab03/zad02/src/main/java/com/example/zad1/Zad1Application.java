package com.example.zad1;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;

import java.util.stream.Stream;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class Zad1Application {
  public static void main(String[] args) {
    var context = new AnnotationConfigApplicationContext(Zad1Application.class);

    Stream.of(context.getBeanDefinitionNames()).map(context::getBean).forEach(System.out::println);
  }
}
