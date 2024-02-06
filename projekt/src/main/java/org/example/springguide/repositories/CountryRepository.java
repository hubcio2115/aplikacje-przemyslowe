package org.example.springguide.repositories;

import org.example.springguide.domains.country.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.Year;
import java.util.Optional;

public interface CountryRepository extends CrudRepository<Country, Long> {
  Optional<Country> findByNameAndFormationYear(String name, Year formationYear);

  Optional<Country> findByNameOrFormationYear(String name, Year formationYear);

  @Query(
      """
              SELECT c FROM Country c
              WHERE LOWER(c.name) LIKE LOWER(:name)
              AND c.formationYear > :formationYear
              AND c.isInEurope = :isInEurope
              ORDER BY CASE WHEN :descending = true THEN c.name END ASC,
              CASE WHEN :descending = false THEN c.name END DESC
              """)
  Page<Country> find(String name, boolean isInEurope, Year formationYear, boolean descending, Pageable pageable);

  @Query(
          """
                  SELECT c FROM Country c
                  LEFT JOIN FETCH c.ruler r
                  WHERE LOWER(c.name) LIKE LOWER(:name)
                  AND c.formationYear > :formationYear
                  AND c.isInEurope = :isInEurope
                  ORDER BY CASE WHEN :descending = true THEN c.name END ASC,
                  CASE WHEN :descending = false THEN c.name END DESC
                  """)
  Page<Country> findWithRuler(String name, boolean isInEurope, Year formationYear, boolean descending, Pageable pageable);
}
