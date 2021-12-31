package dataTypes;

import java.math.BigInteger;
import java.util.*;
import java.io.*;


class Solution {
    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        BigInteger t = sc.nextBigInteger();

        for (int i = 0; i < t.longValue(); i++) {

            try {
                long x = sc.nextLong();
//                System.out.println(x + " can be fitted in:");
//                if (x >= -128 && x <= 127) System.out.println("* byte");
                //Complete the code

                StringBuilder sb = new StringBuilder();
                sb.append(x).append(" can be fitted in:").append("\n");

                if (x <= Byte.MAX_VALUE && x >= Byte.MIN_VALUE) {
                    sb.append("* byte").append("\n");
                }

                if (x <= Short.MAX_VALUE && x >= Short.MIN_VALUE) {
                    sb.append("* short").append("\n");
                }

                if (x <= Integer.MAX_VALUE && x >= Integer.MIN_VALUE) {
                    sb.append("* int").append("\n");
                }

                if (x <= Long.MAX_VALUE && x >= Long.MIN_VALUE) {
                    sb.append("* long").append("\n");
                }
                System.out.print(sb);

            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }

        }
    }
}



