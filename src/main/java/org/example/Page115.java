package org.example;

import java.util.Scanner;

public class Page115 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] P = new int[N];
        int[] S = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
            S[i] = P[i];
        }

        for (int i = 0; i < N - 1; i++) {
            int index = i + 1;
            int insertIndex = 0;
            boolean changeNeed = false;
            for (int j = index - 1; j >= 0; j--) {
                if (P[j] > P[index]) {
                    insertIndex = j;
                    changeNeed = true;
                }
            }
            if (changeNeed) {
                S[insertIndex] = P[index];
                for (int k = insertIndex + 1; k <= index; k++) {
                    S[k] = P[k - 1];
                }
                for (int l = 0; l < N; l++) {
                    P[l] = S[l];
                }
            }
        }

        int[] sum = new int[N];
        sum[0] = P[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + P[i];
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = result + sum[i];
        }
        System.out.println(result);
    }
}
