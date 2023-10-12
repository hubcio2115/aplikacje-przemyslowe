package lab01.zad03;

public enum Planet {
  MERCURY(0.2408467 * Zad03.YEAR_ON_EARTH_IN_SECONDS),
  VENUS(0.61519726 * Zad03.YEAR_ON_EARTH_IN_SECONDS),
  MARS(1.8808158 * Zad03.YEAR_ON_EARTH_IN_SECONDS),
  JUPYTER(11.862615 * Zad03.YEAR_ON_EARTH_IN_SECONDS),
  SATURN(29.447498 * Zad03.YEAR_ON_EARTH_IN_SECONDS),
  URANUS(84.016846 * Zad03.YEAR_ON_EARTH_IN_SECONDS),
  NEPTUNE(164.79132 * Zad03.YEAR_ON_EARTH_IN_SECONDS);

  private double year;

  private Planet(double year) {
    this.year = year;
  }

  public double getYear() {
    return this.year;
  }
}
