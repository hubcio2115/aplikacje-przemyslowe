package zad1.services;

import zad1.domains.Country;
import org.springframework.stereotype.Service;
import zad1.domains.CountryDTO;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class CountryService {
  private final Map<String, Country> countries;

  public CountryService(Map<String, Country> countries) {
    this.countries = countries;
  }

  public Map<String, Country> getCountries() {
    return countries;
  }

  public Country getById(UUID id) throws NoSuchElementException {
    var result = this.countries.get(id.toString());

    if (result == null) throw new CountryNotFoundException(id);
    return result;
  }

  public Country save(CountryDTO newCountry) {
    var country =
        new Country(
            UUID.randomUUID(),
            newCountry.name(),
            newCountry.gdp(),
            newCountry.area(),
            newCountry.population());

    this.countries.put(country.id().toString(), country);

    return country;
  }

  public Country put(UUID id, CountryDTO newCountry) {
    var country =
            new Country(
                    id,
                    newCountry.name(),
                    newCountry.gdp(),
                    newCountry.area(),
                    newCountry.population());

    this.countries.put(country.id().toString(), country);

    return country;
  }

  public Country delete(UUID id) {
    return this.countries.remove(id.toString());
  }
}
