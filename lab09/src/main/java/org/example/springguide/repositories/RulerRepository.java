package org.example.springguide.repositories;

import org.example.springguide.domains.ruler.Ruler;
import org.springframework.data.repository.CrudRepository;

public interface RulerRepository extends CrudRepository<Ruler, Long> {
}
