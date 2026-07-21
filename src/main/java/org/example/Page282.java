package org.example;

import java.util.Scanner;

public class Page282 {
    public static int[] node;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        node = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            node[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int way = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (way == 0) {
                union(a, b);
            } else {
                find(a, b);
            }
        }
    }

    public static void union(int a, int b) {
        while (a != node[a]) {
            a = node[a];
            if (a == node[a]) {
                break;
            }
        }
        while (b != node[b]) {
            b = node[b];
            if (b == node[b]) {
                break;
            }
        }
        if (a == b) {
            return;
        }
        if (a < b) {
            node[b] = a;
        } else {
            node[a] = b;
        }
    }

    public static void find(int a, int b) {
        while (a != node[a]) {
            a = node[a];
            if (a == node[a]) {
                break;
            }
        }
        while (b != node[b]) {
            b = node[b];
            if (b == node[b]) {
                break;
            }
        }

        if (a == b) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
