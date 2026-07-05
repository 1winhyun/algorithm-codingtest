package org.example;

import java.util.*;

public class Page94 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] x = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
        }

        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            int a = Math.abs(o1);
            int b = Math.abs(o2);
            if (a == b) {
                return o1 > o2 ? 1 : -1;
            } else {
                return a - b;
            }
        });
        for (int i = 0; i < N; i++) {
            if (x[i] == 0) {
                if (q.isEmpty()) {
                    System.out.println(0);
                } else {
                    int n = q.poll();
                    System.out.println(n);
                }
            } else {
                q.add(x[i]);
            }
        }
    }
}
