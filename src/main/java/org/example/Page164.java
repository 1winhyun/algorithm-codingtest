package org.example;

import java.util.*;
import java.io.*;

public class Page164 {
    public static ArrayList<Integer>[] A;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int v = sc.nextInt();

        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            A[a].add(b);
            A[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A[i]);
        }

        visited = new boolean[N + 1];
        DFS(v);

        System.out.print("\n");
        visited = new boolean[N + 1];
        BFS(v);
    }

    public static void DFS(int startNode) {
        System.out.print(startNode + " ");
        if (visited[startNode]) {
            return;
        }
        visited[startNode] = true;
        for (int i : A[startNode]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int startNode) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(startNode);
        visited[startNode] = true;

        while (!q.isEmpty()) {
            int result = q.poll();
            System.out.print(result + " ");
            for (int i : A[result]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
