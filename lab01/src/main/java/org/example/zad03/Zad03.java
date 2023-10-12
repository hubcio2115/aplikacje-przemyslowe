package org.example.zad03;

public class Zad03 {
  public static final double YEAR_ON_EARTH_IN_SECONDS = 31557600;

  public static double zad03(int age, Planet planet) {
    return age * YEAR_ON_EARTH_IN_SECONDS * planet.getYear();
  }
}
