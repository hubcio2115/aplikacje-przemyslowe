package com.example.zad2.service;

import com.example.zad2.domains.Person;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Configuration
public class PersonServiceConfiguration {
  @Bean
  @Qualifier("prezes")
  Person prezes() {
    return new Person(
        "bf02c663-d3d1-4be2-8ff9-8d1d7eb85a4e", "John", "Smith", "john.smith@example.com", 1975);
  }

  @Bean
  @Qualifier("wiceprezes")
  public Person wiceprezes() {
    return new Person(
        "0e07f3ff-5ac0-4290-b1a7-e08e7d35b601", "Jane", "Doe", "jane.doe@example.com", 1982);
  }

  @Bean
  @Qualifier("sekretarz")
  public Person sekretarz() {
    return new Person(
        "9b5f0046-61ca-45c5-b3d1-eb8a1cb6fba7",
        "Michael",
        "Johnson",
        "michael.johnson@example.com",
        1992);
  }

  @Bean
  @Qualifier("people")
  public List<Person> peopleFromCSV(@Value("${in.csv.file}") String csvFilePath)
      throws IOException, CsvException {
    var resource = new ClassPathResource(csvFilePath);

    var reader = new InputStreamReader(resource.getInputStream());

    var csvReader =
        new CSVReaderBuilder(reader)
            .withSkipLines(1)
            .build();

    return CSVParser.parse(csvReader);
  }
}
