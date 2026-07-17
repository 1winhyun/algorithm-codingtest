package org.example;

import java.util.*;

public class Page265 {
    public static ArrayList<Integer>[] A;
    public static boolean[] visited;
    public static int count;
    public static int[] resultCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        A = new ArrayList[N + 1];
        resultCount = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            A[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            count = 1;
            BFS(i);
        }

        int max = resultCount[1];
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, resultCount[i]);
        }

        for (int i = 1; i <= N; i++) {
            if (resultCount[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    public static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.add(node);
        while (!q.isEmpty()) {
            int pollNode = q.poll();
            for (int i : A[pollNode]) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    count = count + 1;
                }
            }
        }
        resultCount[node] = count;
    }
}
