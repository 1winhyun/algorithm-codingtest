package org.example;

import java.util.*;

public class Page224 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] A = new int[10000001];

        for (int i = 2; i < 10000001; i++) {
            A[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(10000001); i++) {
            if (A[i] == 0) {
                continue;
            }
            for (int j = i; j < 10000001; j = j + i) {
                if (A[j] != i) {
                    A[j] = 0;
                }
            }
        }

        for (int i = N; i < 10000001; i++) {
            if (A[i] == 0) {
                continue;
            }
            boolean palind = palindrome(A[i]);

            if (palind) {
                System.out.println(A[i]);
                break;
            }
        }
    }

    public static boolean palindrome(int prime) {
        Queue<String> q = new LinkedList<>();
        Queue<String> reverseQ = new LinkedList<>();

        String s = String.valueOf(prime);
        for (int i = 0; i < s.length(); i++) {
            q.add(s.split("")[i]);
            reverseQ.add(s.split("")[s.length() - 1 - i]);
        }

        boolean isSame = true;
        for (int i = 0; i < s.length(); i++) {
            if (!q.remove().equals(reverseQ.remove())) {
                isSame = false;
                break;
            }
        }
        return isSame;
    }
}
