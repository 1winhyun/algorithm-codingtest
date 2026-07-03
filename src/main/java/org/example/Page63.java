package org.example;

import java.util.*;
import java.io.*;

public class Page63 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);
        int count = 0;

        for (int i = 2; i < N; i++) {
            int gn = a[i];
            int end = i - 1;
            int start = 0;

            while (start != i - 1) {
                int sum = a[start] + a[end];

                if (start == end) {
                    start++;
                    end = i - 1;
                } else if (sum == gn) {
                    count++;
                    start = i - 1;
                } else {
                    end--;
                }
            }
        }
        System.out.println(count);
    }
}
