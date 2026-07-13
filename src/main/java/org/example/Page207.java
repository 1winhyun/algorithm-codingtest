package org.example;

import java.util.*;

public class Page207 { // 다시 풀어보기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] A = new int[N][2];
        for (int i = 0; i < N; i++) {
            A[i][0] = sc.nextInt();
            A[i][1] = sc.nextInt();
        }

        Arrays.sort(A, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[1];
            }
            return a[1] - b[1];
        });

        int count = 0;
        int end = -1;
        for (int i = 0; i < N; i++) {
            if (A[i][0] >= end) {
                end = A[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
