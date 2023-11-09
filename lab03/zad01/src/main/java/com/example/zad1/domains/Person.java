package zad1.domains;

public class Person {
  private final String id;
  private final String name;
  private final String lastname;
  private final int dateOfBirth;

  public Person(String id, String name, String lastname, int dateOfBirth) {
    this.id = id;
    this.name = name;
    this.lastname = lastname;
    this.dateOfBirth = dateOfBirth;
  }

  @Override
  public String toString() {
    return String.format(
        "{ id: %s, name: %s, lastname: %s, dateOfBirth: %d }",
        this.id, this.name, this.lastname, this.dateOfBirth);
  }
}
