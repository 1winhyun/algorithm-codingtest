package org.example;

import java.util.*;

public class Page59 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] n = new int[N];
        for (int i = 0; i < N; i++) {
            n[i] = sc.nextInt();
        }

        int start = 0;
        int end = N - 1;
        int sum;
        int count = 0;
        while (start != N) {
            sum = n[start] + n[end];
            if (sum == M) {
                count++;
                start++;
                end = N - 1;
            } else if (start == end) {
                start++;
                end = N - 1;
            } else {
                end--;
            }
        }

        System.out.println(count);
    }
}
