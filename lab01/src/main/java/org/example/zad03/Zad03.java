package org.example.zad03;

import java.util.Map;

public class Zad03 {
    private static final double YEAR_ON_EARTH_IN_SECONDS = 31557600;
    private static final Map<Planets, Double> YEAR_ON_PLANETS_IN_SECONDS = Map.of(
            Planets.MERCURY, 0.2408467 * YEAR_ON_EARTH_IN_SECONDS,
            Planets.VENUS, 0.61519726 * YEAR_ON_EARTH_IN_SECONDS,
            Planets.MARS, 1.8808158 * YEAR_ON_EARTH_IN_SECONDS,
            Planets.JUPYTER, 11.862615 * YEAR_ON_EARTH_IN_SECONDS,
            Planets.SATURN, 29.447498 * YEAR_ON_EARTH_IN_SECONDS,
            Planets.URANUS, 84.016846 * YEAR_ON_EARTH_IN_SECONDS,
            Planets.NEPTUNE, 164.79132 * YEAR_ON_EARTH_IN_SECONDS
            );


    public static double zad03(int age, Planets planet) {
         return age * YEAR_ON_EARTH_IN_SECONDS * YEAR_ON_PLANETS_IN_SECONDS.get(planet);
    }
}
