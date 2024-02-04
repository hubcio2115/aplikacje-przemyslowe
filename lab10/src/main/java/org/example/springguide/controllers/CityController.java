package org.example.springguide.controllers;

import lombok.AllArgsConstructor;
import org.example.springguide.domains.city.City;
import org.example.springguide.domains.city.CityDTO;
import org.example.springguide.services.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/cities")
@AllArgsConstructor
public class CityController {
    private final CityService cityService;

    @GetMapping("{id}")
    public ResponseEntity<Optional<City>> getCityById(@PathVariable long id) {
        var city = this.cityService.getById(id);

        if (city.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(city);
    }

    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody CityDTO city) {
        var newCity = City.builder()
                .name(city.name())
                .build();

        return ResponseEntity.ok(this.cityService.addCity(newCity));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Optional<City>> deleteCity(@PathVariable long id) {
        var deletedCity = this.cityService.deleteById(id);

        if (deletedCity.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(deletedCity);
    }
}
