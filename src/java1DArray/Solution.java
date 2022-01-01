package java1DArray;

import java.io.StringReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scan = new Scanner(new StringReader("5\n" +
                "10\n" +
                "20\n" +
                "30\n" +
                "40\n" +
                "50"));
        int n = scan.nextInt();

        int[] a = new int[n];
        int j = 0;
        while (j < n) {
            a[j] = scan.nextInt();
            j++;
        }
        scan.close();

        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}