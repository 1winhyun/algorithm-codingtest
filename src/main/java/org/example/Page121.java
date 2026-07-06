package org.example;

import java.util.*;

public class Page121 { // 잘 이해가 안가니 다시 해보기.
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

    public static void sort(int[] A, int start, int end, int k) {
        if (start < end) {
            int pivot = partition(A, start, end);
            if (pivot == k) {
                return;
            } else if (k < pivot) {
                sort(A, start, pivot - 1, k);
            } else {
                sort(A, pivot + 1, end, k);
            }
        }
    }

    public static int partition(int[] A, int start, int end) {
        if (start + 1 == end) {
            if (A[start] > A[end]) {
                swap(A, start, end);
            }
            return end;
        }

        int m = (start + end) / 2;
        swap(A, start, m);
        int pivot = A[start];
        int i = start + 1;
        int j = end;
        while (i <= j) {
            while (j >= start + 1 && pivot < A[j]) {
                j--;
            }
            while (i <= end && pivot > A[i]) {
                i++;
            }
            if (i <= j) {
                swap(A, i++, j--);
            }
        }

        A[start] = A[j];
        A[j] = pivot;
        return j;
    }

    public static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
