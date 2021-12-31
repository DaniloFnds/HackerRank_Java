package minimumBribes;

import java.io.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q2) {
        // Write your code here
        final Integer[] q = q2.toArray(new Integer[]{});

        int swaps = 0;
        for (int i = q.length - 1; i > 0; i--) {
            if (q[i] != i + 1) { //se o ultimo numero for diferente do numero corrente: q[i]
//                System.out.println();
                if ((i - 1) >= 0 && q[i - 1] == i + 1) {
                    int temp = q[i - 1];
                    q[i - 1] = q[i];
                    q[i] = temp;
                    swaps++;
//                    System.out.println();
                    //descobriu q a posicao atual deveria ser o 8, pela ordem de sequencia de tras pra frente
                } else if ((i - 2) >= 0 && q[i - 2] == i + 1) {

                    int temp = q[i];
                    q[i] = q[i - 2];
                    q[i - 2] = q[i - 1];
                    q[i - 1] = temp;

                    swaps += 2;
                } else {
                    System.out.println("Choatic");
                    return;
                }
            }
        }
        System.out.println(swaps);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("D:/input09.txt"))));
    /*    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new StringBufferInputStream("1\n" +
                "8\n" +
                "1 2 5 3 7 8 6 4")));*/

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        final LocalDateTime start = LocalDateTime.now();
        System.out.println(start);
        IntStream.range(0, t).forEach(tItr -> {
            try {
                bufferedReader.readLine();
//                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        System.out.println(start.until(LocalDateTime.now(), ChronoUnit.SECONDS));
        bufferedReader.close();
    }
}
