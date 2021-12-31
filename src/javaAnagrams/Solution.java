package javaAnagrams;

import java.io.StringBufferInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        // Complete the function

        if (a.length() != b.length()) {
            return false;
        }

        int qtIguais = 0;
        for (int i = 0; i < a.length(); i++) {
            int tamanhoA = 0;
            int tamanhoB = 0;
            char ultimoA = a.charAt(i);
            for (int j = 0; j < a.length(); j++) {
                if (ultimoA == a.charAt(j)) {
                    tamanhoA++;
                }
            }
            char ultimoB = 0;
            for (int j = 0; j < b.length(); j++) {
                ultimoB = b.charAt(j);
                tamanhoB = 0;
                for (int k = 0; k < b.length(); k++) {
                    if (ultimoB == b.charAt(k)) {
                        tamanhoB++;
                    }
                }
            }

            if (ultimoA == ultimoB && !(tamanhoA == tamanhoB)) {
                return false;
            }

            if (ultimoA == ultimoB) {
                qtIguais++;
            }
        }

        return qtIguais != 0;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(new StringBufferInputStream("Hello\n" +
                "hello"));
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }
}
