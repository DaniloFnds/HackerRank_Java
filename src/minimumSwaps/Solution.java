package minimumSwaps;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        int swaps = 0, index = 0, temp;

        while (index < arr.length) {
            if (arr[index] != index + 1) { //nao pode ser igual ao index atual
                temp = arr[index];
                 arr[index] = arr[arr[index] - 1];
                arr[temp - 1] = temp;
                swaps++;
            } else {
                index++;
            }
        }
        return swaps;
    }

    /*      private static final Scanner scanner = new Scanner(new StringBufferInputStream("4\n" +
                  "4 3 1 2"));  */
    private static Scanner scanner = null;

    static {
        try {
//            scanner = new Scanner(new FileInputStream("D:/input14.txt"));
            scanner = new Scanner(new StringBufferInputStream("7\n" + "1 3 5 2 4 6 7"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
