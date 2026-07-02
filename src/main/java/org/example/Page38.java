package org.example;

import java.util.*;

public class Page38 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        float[] scores = new float[N];
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
        }

        float M = 0;
        for (int i = 0; i < N; i++) {
            if (scores[i] > M) {
                M = scores[i];
            }
        }

        float sum = 0;
        for (int i = 0; i < N; i++) {
            scores[i] = scores[i] / M * 100;
            sum += scores[i];
        }

        System.out.println(sum / N);
    }
}
