package org.example.springguide.repositories;

import org.example.springguide.domains.citizen.Citizen;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CitizenRepository extends CrudRepository<Citizen, Long> {
  @Query(
      "SELECT c FROM Citizen c LEFT JOIN FETCH c.countries country WHERE country.id = :countryId")
  Iterable<Citizen> findAllFromACountry(long countryId);
}
