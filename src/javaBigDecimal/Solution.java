package javaBigDecimal;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        //Input
        Scanner sc = new Scanner(new File("D:/input04.txt"));
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        //Write your code here

        Arrays.sort(s, (o1, o2) -> {
            if (o1 == null || o2 == null) {
                return 0;
            }
            return new BigDecimal(o2).compareTo(new BigDecimal(o1));
        });

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }

    }
}