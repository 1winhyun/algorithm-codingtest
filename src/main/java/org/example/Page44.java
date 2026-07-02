package org.example;

import java.util.*;

public class Page44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] numbers = new int[N + 1];
        numbers[0] = 0;
        for (int a = 1; a <= N; a++) {
            numbers[a] = sc.nextInt();
        }

        int[] s = new int[N + 1];
        s[0] = 0;
        for (int b = 1; b <= N; b++) {
            s[b] = s[b - 1] + numbers[b];
        }

        int[] i = new int[M];
        int[] j = new int[M];
        for (int c = 0; c < M; c++) {
            i[c] = sc.nextInt();
            j[c] = sc.nextInt();
        }

        for (int b = 0; b < M; b++) {
            int sum;
            sum = s[j[b]] - s[i[b] - 1];

            System.out.println(sum);
        }
    }
}
