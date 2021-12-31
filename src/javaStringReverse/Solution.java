package javaStringReverse;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(new StringBufferInputStream("madam"));
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */


        final String reversed = new StringBuilder(A).reverse().toString();

        if(A.compareTo(reversed) == 0) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }
}



