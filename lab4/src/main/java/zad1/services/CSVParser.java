package zad1.services;

import zad1.domains.Country;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CSVParser {
  public static Map<String, Country> parse(com.opencsv.CSVReader reader)
      throws IOException, CsvException {
    var result = new HashMap<String, Country>();

    for (String[] row : reader.readAll()) {
      var id = UUID.randomUUID();
      var country =
          new Country(
              id, row[1], Long.parseLong(row[2]), Long.parseLong(row[3]), Long.parseLong(row[4]));

      result.put(id.toString(), country);
    }

    return result;
  }
}
