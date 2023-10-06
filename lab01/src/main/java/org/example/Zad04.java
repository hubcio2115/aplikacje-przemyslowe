package org.example;

public class Zad04 {
    public static void zad04(int n) {
        for (int i = 1; i <= n; i++) System.out.println("x".repeat(i));

        for (int i = n; i > 0; i--) System.out.println("x".repeat(i));

        for (int i = n; i > 0; i--) System.out.println(" ".repeat(n - i) + "x".repeat(i));

        for (int i = 1; i <= n; i++) System.out.println(" ".repeat(n - i) + "x".repeat(i));
    }
}
