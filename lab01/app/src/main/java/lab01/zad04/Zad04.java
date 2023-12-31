package lab01.zad04;

public class Zad04 {
  private static final String DEFAULT_PATTERN = "x";

  public static String printPattern(int n) {
    return printPattern(DEFAULT_PATTERN, n);
  }

  public static String printPattern(String pattern, int n) {
    var result = new StringBuilder();

    for (int i = 1; i <= n; i++) result.append(pattern.repeat(i) + "\n");

    for (int i = n; i > 0; i--) result.append(pattern.repeat(i) + "\n");

    for (int i = n; i > 0; i--) result.append(" ".repeat(n - i) + pattern.repeat(i) + "\n");

    for (int i = 1; i <= n; i++) result.append(" ".repeat(n - i) + pattern.repeat(i) + "\n");

    return result.toString();
  }
}
