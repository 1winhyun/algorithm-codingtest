package org.example;

import java.util.*;

public class Page86 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int[] results = new int[N];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        for (int i = 1; i < N; i++) {
            while (!stack.isEmpty() && A[i] > A[stack.peek()]) {
                int n = stack.pop();
                results[n] = A[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int n = stack.pop();
            results[n] = -1;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(results[i] + " ");
        }
    }
}
