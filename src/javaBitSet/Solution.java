package javaBitSet;

import java.io.StringReader;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        final Scanner sc = new Scanner(new StringReader("10 8\n" +
                "SET 1 1\n" +
                "SET 1 2\n" +
                "SET 1 0\n" +
                "AND 1 2\n" +
                "SET 2 1\n" +
                "SET 2 2\n" +
                "SET 2 0\n" +
                "AND 2 1"));
//        final Scanner sc = new Scanner(System.in);
        final String[] s1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        int operations = 0;
        final BitSet bitSet1 = new BitSet(n);
        final BitSet bitSet2 = new BitSet(n);

        while (operations < m) {
            final String[] s = sc.nextLine().split(" ");
            final String operation = s[0];
            final int b1 = Integer.parseInt(s[1]);
            final int b2 = Integer.parseInt(s[2]);

            if ("AND".equals(operation)) {
                if (b1 == 1) {
                    bitSet1.and(bitSet2);
                } else {
                    bitSet2.and(bitSet1);
                }
                System.out.println(bitSet1.cardinality() + " " + bitSet2.cardinality());
            }

            if ("SET".equals(operation)) {
                if (b1 == 1) {
                    bitSet1.set(b2);
                } else {
                    bitSet2.set(b2);
                }
                System.out.println(bitSet1.cardinality() + " " + bitSet2.cardinality());
            }

            if ("FLIP".equals(operation)) {
                if (b1 == 1) {
                    bitSet1.flip(b2);
                } else {
                    bitSet2.flip(b2);
                }
                System.out.println(bitSet1.cardinality() + " " + bitSet2.cardinality());
            }

            if ("OR".equals(operation)) {
                if (b1 == 1) {
                    bitSet1.or(bitSet2);
                } else {
                    bitSet2.or(bitSet1);
                }
                System.out.println(bitSet1.cardinality() + " " + bitSet2.cardinality());
            }

            if ("XOR".equals(operation)) {
                if (b1 == 1) {
                    bitSet1.xor(bitSet2);
                } else {
                    bitSet2.xor(bitSet1);
                }
                System.out.println(bitSet1.cardinality() + " " + bitSet2.cardinality());
            }
            operations++;
        }
    }
}