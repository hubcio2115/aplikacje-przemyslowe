package zad1;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import zad1.service.CSVParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Zad1Application {
  public static void main(String[] args) throws IOException {
    try (var reader = Files.newBufferedReader(Path.of("./in.csv"))) {
      var csvReader = new CSVReader(reader);

      var people = CSVParser.parse(csvReader);

      people.forEach(
          (id, person) -> {
            System.out.println(person);
          });
    } catch (CsvException e) {
        throw new RuntimeException(e);
    }
  }
}
