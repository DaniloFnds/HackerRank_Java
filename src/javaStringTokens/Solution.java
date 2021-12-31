package javaStringTokens;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(new StringBufferInputStream("                        "));
        String s = scan.nextLine();
        // Write your code here.

        if (s.trim().length() == 0) {
            System.out.println("0");
            return;
        }
        final String[] split = s.trim().split("[ !,?._'@]+");
        System.out.println(split.length);
        for (String value : split) {
            System.out.println(value);
        }

        scan.close();
    }
}

