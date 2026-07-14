package org.example;

import java.util.*;

public class Page217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] nums = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            nums[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i; j <= N; j = j + i) {
                if (nums[j] != i) {
                    nums[j] = 0;
                }
            }
        }

        for (int i = M; i <= N; i++) {
            if (nums[i] != 0) {
                System.out.println(nums[i]);
            }
        }
    }
}
