package org.example;

import java.util.*;

public class Page237 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int yaksu = 0;
        int[] results = new int[T];
        int count = 0;
        for (int i = 0; i < T; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            int big;
            int small;
            if (A > B) {
                big = A;
                small = B;
            } else {
                big = B;
                small = A;
            }

            while (true) {
                int remain = big % small;
                if (remain == 0) {
                    yaksu = small;
                    results[count] = A * B / yaksu;
                    break;
                }
                if (small > remain) {
                    big = small;
                    small = remain;
                } else {
                    big = remain;
                }
            }
            count++;
        }

        for (int i = 0; i < T; i++) {
            System.out.println(results[i]);
        }

    }
}
