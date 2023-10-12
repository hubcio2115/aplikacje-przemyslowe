package lab01.zad02;

import java.util.Arrays;

public class Zad02 {
  public static boolean zad02(Integer number) {
    var numbers = Arrays.stream(number.toString().split("")).map(Integer::parseInt).toList();

    var result = 0;
    for (int i = 0; i < numbers.toArray().length; i++)
      result += (int) Math.pow(numbers.get(i), i + 1);

    return result == number;
  }
}
