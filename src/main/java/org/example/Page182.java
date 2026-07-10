package org.example;

import java.util.*;

public class Page182 {
    public static int[] A;
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        int M = sc.nextInt();

        int[] search = new int[M];
        for (int i = 0; i < M; i++) {
            search[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            binary_search(0, N - 1, search[i]);
        }
    }

    public static void binary_search(int start, int end, int searchNumber) {
        int m = (start + end) / 2;
        if (A[m] == searchNumber) {
            System.out.println("1");
        } else if (A[m] < searchNumber && start < end) {
            start = m + 1;
            binary_search(start, end, searchNumber);
        } else if (A[m] > searchNumber && end > 0) {
            end = m - 1;
            binary_search(start, end, searchNumber);
        } else {
            System.out.println("0");
        }
    }
}
