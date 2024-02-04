package org.example.springguide.controllers;

import lombok.AllArgsConstructor;
import org.example.springguide.domains.country.Country;
import org.example.springguide.domains.country.CountryDTO;
import org.example.springguide.services.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        var newCountry = Country.builder()
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
}
