package com.example.zad1.service;

import com.example.zad1.domains.Person;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.HashMap;

public class CSVParser {
  public static HashMap<String, Person> parse(com.opencsv.CSVReader reader)
      throws CsvException, IOException {
    var result = new HashMap<String, Person>();

    for (String[] values : reader.readAll()) {
      var newPerson =
          new Person(values[0], values[1], values[2], values[3], Integer.parseInt(values[4]));
      result.put(values[0], newPerson);
    }

    return result;
  }
}
