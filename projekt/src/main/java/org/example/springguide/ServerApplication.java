package org.example.springguide;

import org.example.springguide.domains.country.Country;
import org.example.springguide.services.CountryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Year;
import java.util.NoSuchElementException;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public CommandLineRunner setUpApp(CountryService countryService) {
        return args -> {
            var newCountry = Country.builder()
                    .name("Germany")
                    .gdp(400000000)
                    .isInEurope(true)
                    .formationYear(Year.of(1871))
                    .build();

            var country = countryService.addCountry(newCountry);

            var countryFromDb = countryService.getById(country.getId());

            if (countryFromDb.isPresent())
                System.out.println(countryFromDb.get());
            else
                throw new NoSuchElementException("Country not found");

            countryService.deleteById(country.getId());

            countryFromDb = countryService.getById(country.getId());

            if (countryFromDb.isEmpty())
                System.out.println("Deleted successfully");
            else
                throw new RuntimeException("Country not deleted successfully");
        };
    }

}
