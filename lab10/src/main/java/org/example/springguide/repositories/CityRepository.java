package org.example.springguide.repositories;

import org.example.springguide.domains.city.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
}
