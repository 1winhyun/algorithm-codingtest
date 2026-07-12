package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Page182New {
    public static int[] A;
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        int M = sc.nextInt();
        int[] findNums = new int[M];
        for (int i = 0; i < M; i++) {
            findNums[i] = sc.nextInt();
        }

        int start = 0;
        int end = N - 1;
        for (int i = 0; i < M; i++) {
            int findNum = findNums[i];
            int middle = 0;
            while (start <= end) {
                middle = (start + end) / 2;

                if (findNum == A[middle]) {
                    System.out.println("1");
                    break;
                } else if (findNum < A[middle]) {
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
            if (findNum != A[middle]) {
                System.out.println("0");
            }
            start = 0;
            end = N - 1;
        }
    }
}
