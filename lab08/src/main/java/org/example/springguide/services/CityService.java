package org.example.springguide.services;

import org.example.springguide.domains.city.City;
import org.example.springguide.repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Optional<City> getById(long id) {
        return this.cityRepository.findById(id);
    }

    public City addCity(City newCity) {
        return this.cityRepository.save(newCity);
    }


    public Optional<City> deleteById(long id) {
        var city = this.cityRepository.findById(id);
        city.ifPresent(this.cityRepository::delete);
        return city;
    }
}
