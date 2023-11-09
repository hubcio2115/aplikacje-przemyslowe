package com.example.zad1.domains;

import org.springframework.stereotype.Component;


public class Person {
  private String id;
  private String name;
  private String lastname;
  private String email;
  private int dateOfBirth;

  public Person(String id, String name, String lastname, String email, int dateOfBirth) {
    this.id = id;
    this.name = name;
    this.lastname = lastname;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
  }

  @Override
  public String toString() {
    return String.format(
        """
Person: { id: %s, name: %s, lastname: %s, email: %s, dateOfBirth: %d }
""",
        this.id, this.name, this.lastname, this.email, this.dateOfBirth);
  }
}
