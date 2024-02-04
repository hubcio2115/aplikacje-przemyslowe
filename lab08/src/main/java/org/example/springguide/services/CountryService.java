package org.example.springguide.services;

import org.example.springguide.domains.country.Country;
import org.example.springguide.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(
            CountryRepository countryRepository
    ) {
        this.countryRepository = countryRepository;
    }

    public Optional<Country> getById(long id) {
        return this.countryRepository.findById(id);
    }

    public Country addCountry(Country newCountry) {
        return this.countryRepository.save(newCountry);
    }

    public Optional<Country> deleteById(long id) {
        var country = this.countryRepository.findById(id);
        country.ifPresent(this.countryRepository::delete);
        return country;
    }
}
