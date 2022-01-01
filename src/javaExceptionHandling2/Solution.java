package javaExceptionHandling2;

import java.io.StringReader;
import java.util.Scanner;

class MyCalculator {
    /*
     * Create the method long power(int, int) here.
     */

    public long power(int n, int p) throws Exception {
        if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        }

        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        }

        return new Double(Math.pow(n, p)).longValue();
    }

}

public class Solution {
    public static final MyCalculator my_calculator = new MyCalculator();
    public static final Scanner in = new Scanner(new StringReader("3 5\n" +
            "2 4\n" +
            "0 0\n" +
            "-1 -2\n" +
            "-1 3"));

    public static void main(String[] args) {
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int p = in.nextInt();

            try {
                System.out.println(my_calculator.power(n, p));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}