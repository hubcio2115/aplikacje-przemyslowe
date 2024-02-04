package org.example.springguide.services;

import jakarta.transaction.Transactional;
import org.example.springguide.domains.country.Country;
import org.example.springguide.repositories.CountryRepository;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(
            CountryRepository countryRepository
    ) {
        this.countryRepository = countryRepository;
    }

    @Transactional
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

    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    public Optional<Country> findByNameAndFormationYear(String name, Year formationYear) {
        return this.countryRepository.findByNameAndFormationYear(name, formationYear);
    }

    public Optional<Country> findByNameOrFormationYear(String name, Year formationYear) {
        return this.countryRepository.findByNameOrFormationYear(name, formationYear);
    }
}
