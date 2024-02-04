package org.example.springguide.repositories;

import org.example.springguide.domains.passport.Passport;
import org.springframework.data.repository.CrudRepository;

public interface PassportRepository extends CrudRepository<Passport, Long> {
}
