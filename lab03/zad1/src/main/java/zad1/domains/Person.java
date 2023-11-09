package zad1.domains;

public class Person {
  private String id;
  private String name;
  private String lastname;
  private int dateOfBirth;

  @Override
  public String toString() {
    return String.format(
        "{ id: %s, name: %s, lastname: %s, dateOfBirth: %d }",
        this.id, this.name, this.lastname, this.dateOfBirth);
  }
}
