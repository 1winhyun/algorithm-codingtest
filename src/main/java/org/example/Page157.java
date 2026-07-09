package org.example;

import java.util.*;

public class Page157 {
    public static ArrayList<Integer>[] A;
    public static boolean[] visited;
    public static boolean end;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        A = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            A[a].add(b);
            A[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            DFS(i, 1);
        }

        if (end) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }

    public static void DFS(int v, int depth) {
        if (depth == 5 || end) {
            end = true;
            return;
        }
        visited[v] = true;

        for (int i : A[v]) {
            if (!visited[i]) {
                DFS(i, depth + 1);
            }
        }
        visited[v] = false;
    }
}
