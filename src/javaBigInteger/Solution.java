package javaBigInteger;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        final Scanner sc = new Scanner(System.in);

        final BigInteger a = sc.nextBigInteger();
        final BigInteger b = sc.nextBigInteger();

        System.out.println(a.add(b));

        System.out.println(a.multiply(b));
    }
}