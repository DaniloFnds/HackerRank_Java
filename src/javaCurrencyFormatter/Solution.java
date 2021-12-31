package javaCurrencyFormatter;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = Double.parseDouble(scanner.next());
        scanner.close();

        // Write your code here.

        final DecimalFormat format = (DecimalFormat) NumberFormat.getCurrencyInstance();


        final DecimalFormatSymbols dfsen_us = new DecimalFormatSymbols(Locale.US);
        final DecimalFormatSymbols dfsen_IN = new DecimalFormatSymbols(new Locale("en", "IN"));
        final DecimalFormatSymbols dfszh_CN = new DecimalFormatSymbols(Locale.CHINA);
        final DecimalFormatSymbols dfsfr_FR = new DecimalFormatSymbols(Locale.FRANCE);


        format.setDecimalFormatSymbols(dfsen_us);
        System.out.println("US: " + format.format(payment));
        format.setDecimalFormatSymbols(dfsen_IN);
        System.out.println("India: " + format.format(payment));
        format.setDecimalFormatSymbols(dfszh_CN);
        System.out.println("China: " + format.format(payment));
        Locale france = new Locale("fr", "FR");
        NumberFormat franceFormat = NumberFormat.getCurrencyInstance(france);
        System.out.println("France: " + franceFormat.format(payment));
    }
}