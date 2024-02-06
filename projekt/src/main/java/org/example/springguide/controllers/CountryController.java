package org.example.springguide.controllers;

import lombok.AllArgsConstructor;
import org.example.springguide.domains.country.Country;
import org.example.springguide.domains.country.CountryDTO;
import org.example.springguide.services.CountryService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.Optional;

@RestController
@RequestMapping("api/countries")
@AllArgsConstructor
public class CountryController {
  private final CountryService countryService;

  @GetMapping("{id}")
  public ResponseEntity<Optional<Country>> getCountryById(@PathVariable long id) {
    var country = this.countryService.getById(id);

    if (country.isEmpty()) return ResponseEntity.notFound().build();
    return ResponseEntity.ok(country);
  }

  @PostMapping
  public ResponseEntity<Country> addCountry(@RequestBody CountryDTO country) {
    var newCountry =
        Country.builder()
            .name(country.name())
            .gdp(country.gdp())
            .isInEurope(country.isInEurope())
            .formationYear(country.formationYear())
            .build();

    return ResponseEntity.ok(this.countryService.addCountry(newCountry));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Optional<Country>> deleteCountry(@PathVariable long id) {
    var deletedCountry = this.countryService.deleteById(id);

    if (deletedCountry.isEmpty()) return ResponseEntity.notFound().build();
    return ResponseEntity.ok(deletedCountry);
  }

  @GetMapping
  public ResponseEntity<Iterable<Country>> getAllCountries() {
    return ResponseEntity.ok(this.countryService.findAll());
  }

  @GetMapping("find")
  public ResponseEntity<Page<Country>> find(
      @RequestParam(required = false, defaultValue = "") String name,
      @RequestParam(required = false, defaultValue = "false") boolean isInEurope,
      @RequestParam(required = false, defaultValue = "false") boolean withRuler,
      @RequestParam(required = false, defaultValue = "0") Year formationYear,
      @RequestParam(required = false, defaultValue = "false") boolean descending,
      @RequestParam(required = false, defaultValue = "0") int pageNumber) {
    var countries =
        this.countryService.find(
            name, isInEurope, withRuler, formationYear, descending, pageNumber);

    return ResponseEntity.ok(countries);
  }

  @GetMapping("findByNameAndFormationYear")
  public ResponseEntity<Optional<Country>> getByNameAndFormationYear(
      @RequestParam String name, @RequestParam Year formationYear) {
    var country = this.countryService.findByNameAndFormationYear(name, formationYear);

    if (country.isEmpty()) return ResponseEntity.notFound().build();
    return ResponseEntity.ok(country);
  }

  @GetMapping("findByNameOrFormationYear")
  public ResponseEntity<Optional<Country>> getByNameOrFormationYear(
      @RequestParam String name, @RequestParam Year formationYear) {
    var country = this.countryService.findByNameOrFormationYear(name, formationYear);

    if (country.isEmpty()) return ResponseEntity.notFound().build();
    return ResponseEntity.ok(country);
  }
}
