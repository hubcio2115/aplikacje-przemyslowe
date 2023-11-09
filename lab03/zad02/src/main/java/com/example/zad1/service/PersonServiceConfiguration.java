package com.example.zad1.service;

import com.example.zad1.domains.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.zad1.domains")
public class PersonServiceConfiguration {
  @Bean
  Person prezes() {
    return new Person(
        "bf02c663-d3d1-4be2-8ff9-8d1d7eb85a4e", "John", "Smith", "john.smith@example.com", 1975);
  }

  @Bean
  Person wiceprezes() {
    return new Person(
        "0e07f3ff-5ac0-4290-b1a7-e08e7d35b601", "Jane", "Doe", "jane.doe@example.com", 1982);
  }

  @Bean
  Person sekretarz() {
    return new Person(
        "9b5f0046-61ca-45c5-b3d1-eb8a1cb6fba7",
        "Michael",
        "Johnson",
        "michael.johnson@example.com",
        1990);
  }
}
