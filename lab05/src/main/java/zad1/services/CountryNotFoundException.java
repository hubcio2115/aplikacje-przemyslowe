package zad1.services;

import java.util.UUID;

class CountryNotFoundException extends RuntimeException {

  CountryNotFoundException(UUID id) {
    super("Could not find country " + id);
  }
}
