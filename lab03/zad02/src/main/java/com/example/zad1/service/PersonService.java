package com.example.zad1.service;

import com.example.zad1.domains.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
  private final Person prezes;

  @Autowired
  public PersonService(Person prezes) {
    this.prezes = prezes;
  }

  @Override
  public String toString() {
    return String.format("""
PersonService {
  prezes: %s,
}
""", this.prezes);
  }
}
