package org.example.zad05;

public class Author {
    private final String name;
    private final String email;
    private final Gender gender;

    public Author(String name, String email, Gender gender) {
       this.name = name;
       this.email = email;
       this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("Author[name=%s,email=%s,gender=%s]", this.name, this.email, this.gender);
    }
}
