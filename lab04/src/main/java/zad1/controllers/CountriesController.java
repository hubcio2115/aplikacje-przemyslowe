package zad1.controllers;

import zad1.domains.Country;
import zad1.domains.CountryDTO;
import zad1.services.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
public class CountriesController {
  private final CountryService countryService;

  public CountriesController(CountryService countryService) {
    this.countryService = countryService;
  }

  @GetMapping("/countries")
  Map<String, Country> all() {
    return this.countryService.getCountries();
  }

  @GetMapping("/countries/{id}")
  Country one(@PathVariable UUID id) {
    return this.countryService.getById(id);
  }

  @PostMapping("/countries")
  Country newCountry(@RequestBody CountryDTO newCountry) {
    return this.countryService.save(newCountry);
  }

  @PutMapping("/countries/{id}")
  Country updateCountry(@PathVariable UUID id, @RequestBody CountryDTO country) {
    return this.countryService.put(id, country);
  }

  @DeleteMapping("/countries/{id}")
  Country deleteCountry(@PathVariable UUID id) {
    return this.countryService.delete(id);
  }
}
