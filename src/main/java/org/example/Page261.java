package org.example;

import java.util.*;

public class Page261 {
    public static ArrayList<Integer>[] A;
    public static int[] visited;
    public static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int X = sc.nextInt();

        A = new ArrayList[N + 1];
        visited = new int[N + 1];
        count = 0;

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Integer>();
            visited[i] = 0;
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            A[a].add(b);
        }

        BFS(X);
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (visited[i] == K) {
                result.add(i);
            }
        }
        if (result.isEmpty()) {
            System.out.println("-1");
        }
        Collections.sort(result);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static void BFS(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int pollNode = q.poll();
            for (int i : A[pollNode]) {
                if (visited[i] == 0) {
                    visited[i] = visited[pollNode] + 1;
                    q.add(i);
                }
            }
        }
    }
}
