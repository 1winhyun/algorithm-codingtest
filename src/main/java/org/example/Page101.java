package org.example;

import java.util.*;

public class Page101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        int middle;
        int k = 1;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 1; j < N; j++) {
                if (numbers[k - 1] > numbers[k]) {
                    middle = numbers[k - 1];
                    numbers[k - 1] = numbers[k];
                    numbers[k] = middle;
                }
                k++;
            }
            k = 1;
        }

        for (int i = 0; i < N; i++) {
            System.out.println(numbers[i]);
        }
    }
}
