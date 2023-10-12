package lab01.zad04;

public class Zad04 {
  public static String printPattern(String pattern, int n) {
    var result = new StringBuilder();

    for (int i = 1; i <= n; i++) result.append(pattern.repeat(i) + "\n");

    for (int i = n; i > 0; i--) result.append(pattern.repeat(i) + "\n");

    for (int i = n; i > 0; i--) result.append(" ".repeat(n - i) + pattern.repeat(i) + "\n");

    for (int i = 1; i <= n; i++) result.append(" ".repeat(n - i) + pattern.repeat(i) + "\n");

    return result.toString();
  }
}
