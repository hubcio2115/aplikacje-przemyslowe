package zad1.service;

import com.opencsv.exceptions.CsvException;
import zad1.domains.Person;

import java.io.IOException;
import java.util.HashMap;

public class CSVParser {
  public static HashMap<String, Person> parse(com.opencsv.CSVReader reader)
      throws IOException, CsvException {
    var result = new HashMap<String, Person>();

    for (String[] strings : reader.readAll()) {
      var newPerson = new Person(strings[0], strings[1], strings[2], Integer.parseInt(strings[3]));
      result.put(strings[0], newPerson);
    }

    return result;
  }
}
