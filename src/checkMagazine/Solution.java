package checkMagazine;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'checkMagazine' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY magazine
     *  2. STRING_ARRAY note
     */

    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        Map<String, Integer> mapaMagazine = new HashMap<>();
        for (String m : magazine) {
            mapaMagazine.put(m, mapaMagazine.containsKey(m)? mapaMagazine.get(m) +1 : 1);
        }

        Map<String, Integer> mapaNota = new HashMap<>();
        for (String n : note) {
            mapaNota.put(n, mapaNota.containsKey(n)? mapaNota.get(n) +1 : 1);
        }

        String result = "Yes";
        //VERIFICAR DOQ POSSIVELMENTE NAO TEM TANTO, PARA OQ TENHO DISPONIVEL
        //EU TENHO 10 PALAVRAS E PRECISO VERIFICAR SE NO MONTANDO DE 2 TEM ESSAS PALAVRAS, NO CASO NAO VAI TER
        for (String n : mapaNota.keySet()) {
            if (!mapaMagazine.containsKey(n) || ( mapaNota.get(n) > mapaMagazine.get(n))) {
                result = "No";
                break;
            }
        }
        System.out.println(result);
    }

 /*   mapaNota.entrySet().removeIf(b -> {
        if (entry.getValue() && b.getKey().equals(entry.getKey())) {
            mapaMagazine.replace(entry.getKey(), false);
            return true;
        }
        return false;
    }*/

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:/input12.txt"))));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new StringBufferInputStream("6 5\n" +                "two times three is not four\n" +                "two times two is four")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        List<String> magazine = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<String> note = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        Result.checkMagazine(magazine, note);

        bufferedReader.close();
    }
}
