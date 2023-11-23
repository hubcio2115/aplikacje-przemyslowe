package zad1.services;

import zad1.domains.Country;
import org.springframework.stereotype.Service;
import zad1.domains.CountryDTO;
import zad1.exceptions.CountryNotFoundException;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class CountryService {
  private final Map<UUID, Country> countries;

  public CountryService(Map<UUID, Country> countries) {
    this.countries = countries;
  }

  public Map<UUID, Country> getCountries() {
    return countries;
  }

  public Country getById(UUID id) throws NoSuchElementException {
    var result = this.countries.get(id);

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

    this.countries.put(country.id(), country);

    return country;
  }

  public void put(UUID id, CountryDTO newCountry) {
    var country =
            new Country(
                    id,
                    newCountry.name(),
                    newCountry.gdp(),
                    newCountry.area(),
                    newCountry.population());

    this.countries.put(country.id(), country);
  }

  public Optional<Country> delete(UUID id) {
    return Optional.ofNullable(this.countries.remove(id));
  }
}
