package javaDequeue;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws FileNotFoundException {
        final LocalDateTime start = LocalDateTime.now();
        Scanner in = new Scanner(new File("D:/input10.txt"));
        Deque<Integer> deque = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int max = map.size();
        for (int i = 0; i < n; i++) {
            if (i >= m) {
                int old = deque.remove();
                if (map.get(old) == 1) {
                    map.remove(old);
                } else {
                    map.put(old, map.get(old) - 1);
                }
            }
            int num = in.nextInt();
            deque.add(num);
            map.merge(num, 1, Integer::sum);

            max = Math.max(max, map.size());

            if (max == m) {
                break;
            }
        }

        in.close();
        System.out.println(max);
        System.out.println(start.until(LocalDateTime.now(), ChronoUnit.MILLIS));
    }
}




