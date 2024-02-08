package org.example.springguide.services;

import jakarta.transaction.Transactional;
import org.example.springguide.domains.country.Country;
import org.example.springguide.domains.country.CountryDTO;
import org.example.springguide.repositories.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.Optional;

@Service
public class CountryService {
  private final CountryRepository countryRepository;

  public CountryService(CountryRepository countryRepository) {
    this.countryRepository = countryRepository;
  }

  @Transactional
  public Optional<Country> findById(long id) {
    return this.countryRepository.findById(id);
  }

  @Transactional
  public Country addCountry(CountryDTO newCountry) {
    var country =
        Country.builder()
            .name(newCountry.name())
            .gdp(newCountry.gdp())
            .isInEurope(newCountry.isInEurope())
            .formationYear(newCountry.formationYear())
            .build();

    return this.countryRepository.save(country);
  }

  public Optional<Country> deleteById(long id) {
    var country = this.countryRepository.findById(id);
    country.ifPresent(this.countryRepository::delete);
    return country;
  }

  public Page<Country> find(
      String name,
      boolean isInEurope,
      boolean withRuler,
      Year formationYear,
      boolean descending,
      Pageable pageable) {
    if (withRuler)
      return this.countryRepository.findWithRuler(
          name, isInEurope, formationYear, descending, pageable);
    return this.countryRepository.find(name, isInEurope, formationYear, descending, pageable);
  }

  public Iterable<Country> findAll() {
    return this.countryRepository.findAll();
  }

  public Optional<Country> findByNameAndFormationYear(String name, Year formationYear) {
    return this.countryRepository.findByNameAndFormationYear(name, formationYear);
  }

  public Optional<Country> findByNameOrFormationYear(String name, Year formationYear) {
    return this.countryRepository.findByNameOrFormationYear(name, formationYear);
  }
}
