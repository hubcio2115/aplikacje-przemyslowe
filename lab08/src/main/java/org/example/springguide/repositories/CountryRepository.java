package org.example.springguide.repositories;

import org.example.springguide.domains.country.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
}
