package com.example.zad1.service;

import com.example.zad1.domains.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
  private final Person prezes;
  private final Person wiceprezes;
  private final Person sekretarz;

  public PersonService(
      @Qualifier("prezes") Person prezes,
      @Qualifier("wiceprezes") Person wiceprezes,
      @Qualifier("sekretarz") Person sekretarz) {
    this.prezes = prezes;
    this.wiceprezes = wiceprezes;
    this.sekretarz = sekretarz;
  }

  @Override
  public String toString() {
    return String.format(
        """
Person {
  prezes: %s,
  wiceprezes: %s,
  sekretarz: %s,
}
""",
        this.prezes, this.wiceprezes, this.sekretarz);
  }
}
