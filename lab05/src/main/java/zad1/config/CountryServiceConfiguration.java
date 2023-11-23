package zad1.config;

import zad1.domains.Country;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import zad1.services.CSVParser;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.UUID;

@Configuration
public class CountryServiceConfiguration {
  @Bean
  @Qualifier("countries")
  public Map<UUID, Country> peopleFromCSV(@Value("${countries.csv.file}") String csvFilePath)
      throws IOException, CsvException {
    var resource = new ClassPathResource(csvFilePath);

    var reader = new InputStreamReader(resource.getInputStream());

    var csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();

    return CSVParser.parse(csvReader);
  }
}
