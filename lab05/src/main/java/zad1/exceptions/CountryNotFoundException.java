package zad1.exceptions;

import java.util.UUID;

public class CountryNotFoundException extends RuntimeException {

  public CountryNotFoundException(UUID id) {
    super("Could not find country " + id);
  }
}
