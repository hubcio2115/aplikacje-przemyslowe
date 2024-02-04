package org.example.springguide.repositories;

import org.example.springguide.domains.country.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNullApi;

import java.time.Year;
import java.util.List;
import java.util.Optional;

public interface CountryRepository extends CrudRepository<Country, Long> {
    Optional<Country> findByNameAndFormationYear(String name, Year formationYear);

    Optional<Country> findByNameOrFormationYear(String name, Year formationYear);

    @Query("SELECT c.id, c.name, c.formationYear, c.gdp, c.isInEurope FROM Country c")
    List<Country> findAll();
}
