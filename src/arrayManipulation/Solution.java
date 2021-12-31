package arrayManipulation;

import com.sun.org.apache.bcel.internal.generic.RETURN;

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
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */


    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here
        int[] resultLinha = new int[n];
        int len = queries.size();

        System.out.println();

        for (int i = 1; i <= len; i++) {
            final Integer[] linha = queries.get(i - 1).toArray(new Integer[]{});
            final Integer numK = linha[linha.length - 1];
            for (int j = linha[0]; j < linha[1] + 1; j++) {
                if (resultLinha[j - 1] != 0) {
                    resultLinha[j - 1] = resultLinha[j - 1] + numK;
                } else {
                    resultLinha[j - 1] = numK;
                }
            }
        }


        System.out.println();
        int maior = 0;
        for (int j : resultLinha) {
            if (j > maior) {
                maior = j;
            }
        }
        return maior;
    }

}

public class Solution {

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:/input13.txt"))));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new StringBufferInputStream("5 3\n" + "1 2 100\n" + "2 5 100\n" + "3 4 100")));
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new StringBufferInputStream("10 4\n" + "2 6 8\n" + "3 5 7\n" + "1 8 1\n" + "5 9 15")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
