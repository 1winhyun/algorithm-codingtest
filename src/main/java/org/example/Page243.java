package org.example;

import java.util.*;

public class Page243 {
    public static boolean[] visited;
    public static ArrayList<cNode>[] A;
    public static long minBaesu;
    public static long[] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        A = new ArrayList[N];
        visited = new boolean[N];
        minBaesu = 1;
        D = new long[N];

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<cNode>();
        }

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();

            A[a].add(new cNode(b, p, q));
            A[b].add(new cNode(a, q, p));

            minBaesu = minBaesu * ((long) p * q / euclid(p, q));
        }

        D[0] = minBaesu;
        DFS(0);

        long maxYaksu = D[0];
        for (int i = 1; i < N; i++) {
            maxYaksu = euclid(maxYaksu, D[i]);
        }

        for (int i = 0; i < N; i++) {
            System.out.print(D[i] / maxYaksu + " ");
        }
    }

    public static void DFS(int n) {
        visited[n] = true;
        for (cNode c : A[n]) {
            int nextN = c.getB();
            if (!visited[nextN]) {
                D[nextN] = (D[n] * c.getQ()) / c.getP();
                DFS(nextN);
            }
        }
    }

    public static long euclid(long p, long q) {
        long big;
        long small;
        long remain;
        if (p > q) {
            big = p;
            small = q;
        } else {
            big = q;
            small = p;
        }

        while (true) {
            remain = big % small;
            if (remain == 0) {
                break;
            }
            big = small;
            small = remain;
        }

        return small;
    }

    public static class cNode {
        int b;
        int p;
        int q;

        public cNode(int b, int p, int q) {
            super();
            this.b = b;
            this.p = p;
            this.q = q;
        }

        public int getB() {
            return b;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }
    }
}
