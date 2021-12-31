package countingValleys;

import java.io.*;


class Result {

    public static int countingValleys(int steps, String path) {
        // Write your code here

        final String[] passos = path.split("");

        int start = 0;
        int valley = 0;
        int descidas = 0;
        int subidas = 0;
        for (String passo : passos) {
            if (passo.equals("U")) {
                start += 1;
            }

            if (passo.equals("D")) {
                start -= 1;
            }

            if (start < 0 && passo.equals("D")) {
                descidas++; //descendo abaixo do nivel
            }

            if (descidas > 0 && passo.equals("U")) {
                subidas++;//subindo depois de descer
            }

            if (start == 0 && descidas != 0 && subidas == descidas) {
                valley++;
                subidas=0;
                descidas=0;
            }
        }
        return valley;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
