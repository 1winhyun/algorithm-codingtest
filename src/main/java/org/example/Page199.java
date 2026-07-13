package org.example;

import java.util.*;

public class Page199 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            q.add(num);
        }

        int sum = 0;
        while (q.size() != 1) {
            int first = q.remove();
            int second = q.remove();
            sum = sum + first + second;

            q.add(first + second);
        }

        System.out.println(sum);
    }
}
