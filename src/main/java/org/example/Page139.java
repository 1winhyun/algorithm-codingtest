package org.example;

import java.util.Scanner;

public class Page139 {
    public static int[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        sort(A, 5);
        for (int i = 0; i < N; i++) {
            System.out.println(A[i]);
        }
    }

    public static void sort(int[] A, int max) {
        int[] result = new int[A.length];
        int jarisu = 1;
        int count = 0;

        while (count != max) {
            int[] q = new int[10];
            for (int i = 0; i < A.length; i++) {
                q[(A[i] / jarisu) % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                q[i] = q[i] + q[i - 1];
            }

            for (int i = A.length - 1; i >= 0; i--) {
                result[q[(A[i] / jarisu % 10)] - 1] = A[i];
                q[A[i] / jarisu % 10]--;
            }

            for (int i = 0; i < A.length; i++) {
                A[i] = result[i];
            }

            jarisu = jarisu * 10;
            count++;
        }
    }

}
