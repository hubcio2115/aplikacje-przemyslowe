package org.example.springguide.repositories;

import org.example.springguide.domains.citizen.Citizen;
import org.springframework.data.repository.CrudRepository;

public interface CitizenRepository extends CrudRepository<Citizen, Long> {
}
