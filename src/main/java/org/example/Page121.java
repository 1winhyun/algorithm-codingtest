package org.example;

import java.util.*;

public class Page121 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        sort(A, 0, N - 1, K - 1);
        System.out.println(A[K - 1]);
    }

    public static void sort(int[] A, int s, int e, int k) {
        if (s < e) {
            int pivot = partition(A, s, e);
            if (pivot == k) {
                return;
            } else if (pivot > k) {
                sort(A, s, pivot - 1, k);
            } else {
                sort(A, s + 1, pivot, k);
            }
        }

    }

    public static int partition(int[] A, int s, int e) {
        if (s + 1 == e) {
            if (A[s] > A[e]) {
                swap(A, s, e);
            }
            return e;
        }

        int M = (s + e) / 2;
        swap(A, s, M);
        int pivot = A[s];
        int i = s + 1;
        int j = e;
        while (i <= j) {
            while (j >= s + 1 && pivot < A[j]) {
                j--;
            }
            while (i <= e && pivot > A[i]) {
                i++;
            }

            if (i <= j) {
                swap(A, i++, j--);
            }
        }
        A[s] = A[j];
        A[j] = pivot;
        return j;
    }

    public static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
