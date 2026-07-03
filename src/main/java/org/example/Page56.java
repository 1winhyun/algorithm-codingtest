package org.example;

import java.util.*;

public class Page56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int start = 1;
        int end = 1;
        int count = 1;
        int sum = 1;

        while (end != N) {
            if (sum == N) {
                end++;
                sum = sum + end;
                count++;
            } else if (sum < N) {
                end++;
                sum = sum + end;
            } else {
                sum = sum - start;
                start++;
            }
        }

        System.out.println(count);
    }
}
