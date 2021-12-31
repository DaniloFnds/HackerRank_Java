package miniMaxSum;

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
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
//        O(log n) => O(log 1)
        List<Long> maiores = new ArrayList<>();
        int lastIdx = 0, init = 0;
        long total = 0;
        int len = arr.size();
        while (len > 0) {
            for (int i = 0; i < arr.size(); i++) {
                if (i != lastIdx) {
                    total += arr.get(i);
                }
            }
            if (maiores.size() == 2) {
                if (maiores.get(0) > maiores.get(1)) {
                    long guarda = maiores.get(0);
                    maiores.set(0, maiores.get(1));
                    maiores.set(1, guarda);
                }

                Long menor = maiores.get(0);
                Long maior = maiores.get(1);

                if (total < menor) {
                    long guarda = maiores.get(0);
                    maiores.set(0, total);
                    total = guarda;
                }

                if (total > maior) {
                    maiores.set(1, total);
                }

            } else {
                maiores.add(total);
            }
            lastIdx = init + 1 < arr.size() ? init + 1 : 0;
            total = 0;
            init++;
            len--;
        }

        System.out.println(maiores.get(0) + " " + maiores.get(1));
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new StringBufferInputStream("793810624 895642170 685903712 623789054 468592370")));
        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
