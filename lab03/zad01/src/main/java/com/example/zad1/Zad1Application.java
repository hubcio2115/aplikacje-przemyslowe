package com.example.zad1;

import com.example.zad1.service.CSVParser;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;

public class Zad1Application {
  public static void main(String[] args) {
    try {
      var csvReader = new CSVReaderBuilder(new FileReader(args[0])).withSkipLines(1).build();

      var people = CSVParser.parse(csvReader);

      people.forEach(
          (id, person) -> {
            System.out.println(person);
          });
    } catch (IOException e) {
      System.out.println("Couldn't read the csv file.");
    } catch (CsvException e) {
      System.out.println(e.getMessage());
    }
  }
}
