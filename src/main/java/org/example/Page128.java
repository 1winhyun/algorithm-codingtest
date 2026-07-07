package org.example;

import java.util.*;

public class Page128 {
    public static int[] numbers;
    public static int[] results;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        numbers = new int[N];
        results = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        sort(0, N - 1);
        for (int i = 0; i < N; i++) {
            System.out.println(numbers[i]);
        }

    }

    public static void sort(int s, int e) {
        if (e - s < 1) {
            return;
        }
        int m = (s + e) / 2;
        sort(s, m);
        sort(m + 1, e);

        for (int i = s; i <= e; i++) {
            results[i] = numbers[i];
        }

        int k = s;
        int index1 = s;
        int index2 = m + 1;
        while (index1 <= m && index2 <= e) {
            if (results[index1] > results[index2]) {
                numbers[k] = results[index2];
                k++;
                index2++;
            } else {
                numbers[k] = results[index1];
                k++;
                index1++;
            }
        }
        while (index1 <= m) {
            numbers[k] = results[index1];
            k++;
            index1++;
        }
        while (index2 <= e) {
            numbers[k] = results[index2];
            k++;
            index2++;
        }
    }
}
