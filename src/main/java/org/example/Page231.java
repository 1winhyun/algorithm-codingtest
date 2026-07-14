package org.example;

import java.util.*;

public class Page231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] A = new int[n + 1];
        int[] B = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = i;
            B[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            if (A[i] != B[i]) {
                continue;
            }
            for (int j = i; j <= n; j = j + i) {
                if (A[j] % i == 0) {
                    B[j] = B[j] - (B[j] / i);
                }
            }
        }

        System.out.println(B[n]);
    }
}
