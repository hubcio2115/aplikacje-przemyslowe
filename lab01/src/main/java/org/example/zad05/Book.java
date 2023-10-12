package org.example.zad05;

public class Book {
  private final String name;
  private final Author author;
  private double price;
  private double quantity;

  public Book(String name, double price, Author author, int quantity) {
    this.name = name;
    this.price = price;
    this.author = author;
    this.quantity = quantity;
  }

  public Book(String name, double price, Author author) {
    this(name, price, author, 0);
  }

  public String getName() {
    return name;
  }

  public Author getAuthor() {
    return author;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getQuantity() {
    return quantity;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return String.format(
        "Book[name=%s,author=%s,price=%.2f,quantity=%.2f]",
        this.name, author.toString(), this.price, this.quantity);
  }
}
