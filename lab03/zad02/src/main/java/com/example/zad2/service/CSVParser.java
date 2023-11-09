package com.example.zad2.service;

import com.example.zad2.domains.Person;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVParser {
  public static List<Person> parse(com.opencsv.CSVReader reader) throws CsvException, IOException {
    var result = new ArrayList<Person>();

    for (String[] values : reader.readAll()) {
      var newPerson =
          new Person(values[0], values[1], values[2], values[3], Integer.parseInt(values[4]));
      result.add(newPerson);
    }

    return result;
  }
}
