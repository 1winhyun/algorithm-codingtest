package org.example;

import java.util.*;

public class Page228 {//꼭 다시 풀어보기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long min = sc.nextInt();
        long max = sc.nextInt();

        boolean[] check = new boolean[(int) (max - min + 1)];

        for (long i = 2; i <= Math.sqrt(max); i++) {
            long pow = i * i;
            long start = min / pow;
            if (min % pow != 0) {
                start++;
            }
            for (long j = start; pow * j <= max; j++) {
                check[(int) ((j * pow) - min)] = true;
            }
        }

        int count = 0;
        for (int i = 0; i <= max - min; i++) {
            if (!check[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
