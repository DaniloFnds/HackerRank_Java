package hourglassSum;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here

        int c = 0;

        List<Integer> todosNumeros = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<List<Integer>> reduzir = new ArrayList<>();
            final List<List<Integer>> lists = arr.subList(c, 3 + i);
            int meio = 0;
            for (List<Integer> list : lists) {
                List<Integer> listaReduziada = new ArrayList<>();
                if (meio == 1) {
                    for (int j = 0; j < 4; j++) {
                        final Integer numDoMeio = list.get(j + 1);
                        listaReduziada.add(numDoMeio);
                    }
                    meio = 99;
                } else {
                    listaReduziada = list;
                    meio++;
                }
                List<Integer> resultados = new ArrayList<>();
                for (int j = 0; j < 4; j++) {
                    if (meio == 99) {
                        resultados.add(listaReduziada.get(j));
                    } else {
                        final Integer reduce = listaReduziada.subList(j, 3 + j).stream().reduce(0, Integer::sum);
                        resultados.add(reduce);
                    }

                }
                reduzir.add(resultados);
                System.out.println();
            }
            for (int j = 0; j < 4; j++) {
                int sum = 0;
                for (List<Integer> num : reduzir) {
                    sum += num.get(j);
                }
                todosNumeros.add(sum);
                System.out.println();
            }
            c++;
        }

        return todosNumeros.stream().mapToInt(Integer::intValue).max().orElse(0);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new StringBufferInputStream(
             /*   "-9 -9 -9 1 1 1 \n" +
                  "0 -9 0 4 3 2\n" +
                        "-9 -9 -9 1 2 3\n" +
                        "0 0 8 6 6 0\n" +
                        "0 0 0 -2 0 0\n" +
                        "0 0 1 2 4 0")));*/
                "1 1 1 0 0 0\n" +
                "0 1 0 0 0 0\n" +
                "1 1 1 0 0 0\n" +
                "0 0 2 4 4 0\n" +
                "0 0 0 2 0 0\n" +
                "0 0 1 2 4 0")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
