package zad1.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import zad1.domains.Country;
import zad1.domains.CountryDTO;
import zad1.services.CountryService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CountriesController {
  private final CountryService countryService;

  public CountriesController(CountryService countryService) {
    this.countryService = countryService;
  }

  @GetMapping("/api/countries")
  ResponseEntity<Map<UUID, Country>> all() {
    return ResponseEntity.ok(this.countryService.getCountries());
  }

  @GetMapping("/api/countries/{id}")
  ResponseEntity<Country> one(@PathVariable UUID id) {
    try {
      return ResponseEntity.ok(this.countryService.getById(id));
    } catch (NoSuchElementException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/api/countries")
  ResponseEntity<Country> newCountry(@RequestBody CountryDTO newCountry) {
    return ResponseEntity.ok(this.countryService.save(newCountry));
  }

  @PutMapping("/api/countries/{id}")
  ResponseEntity<Country> updateCountry(@PathVariable UUID id, @RequestBody CountryDTO country) {
    this.countryService.put(id, country);

    return ResponseEntity.ok(countryService.getById(id));
  }

  @DeleteMapping("/api/countries/{id}")
  ResponseEntity<Country> deleteCountry(@PathVariable UUID id) {
    var country = this.countryService.delete(id);

    return country.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }
}
