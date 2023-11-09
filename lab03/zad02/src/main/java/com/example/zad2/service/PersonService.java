package com.example.zad2.service;

import com.example.zad2.domains.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonService {
  private final Person prezes;
  private final Person wiceprezes;
  private final Person sekretarz;
  private final List<Person> people;

  public PersonService(Person prezes, Person wiceprezes, Person sekretarz, List<Person> people) {
    this.prezes = prezes;
    this.wiceprezes = wiceprezes;
    this.sekretarz = sekretarz;
    this.people = people;
  }

  public Person getPrezes() {
    return prezes;
  }

  public Person getWiceprezes() {
    return wiceprezes;
  }

  @Override
  public String toString() {
    return String.format(
        """
PersonService {
  prezes: %s,
  wiceprezes: %s,
  sekretarz: %s,
  people: %s,
}
""",
        this.prezes, this.wiceprezes, this.sekretarz, this.people);
  }
}
