package com.example.zad2.domains;

public class Person {
  private final String id;
  private final String name;
  private final String lastname;
  private final String email;
  private final int dateOfBirth;

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
