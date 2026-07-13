package org.example;

import java.util.*;

public class Page197 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }

        int sum = 0;
        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if ((K - sum) / coins[i] >= 1) {
                int coinNum = (K - sum) / coins[i];
                count = count + coinNum;
                sum = sum + (coins[i] * coinNum);
            }
            if (sum == K) {
                break;
            }
        }

        System.out.println(count);
    }
}
