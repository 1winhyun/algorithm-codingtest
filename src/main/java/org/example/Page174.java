package org.example;

import java.util.*;

public class Page174 {
    public static ArrayList<Edge>[] A;
    public static boolean[] visited;
    public static int[] distance;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        visited = new boolean[N + 1];
        distance = new int[N + 1];

        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < N; i++) {
            int s = sc.nextInt();
            while (true) {
                int e = sc.nextInt();
                if (e == -1) {
                    break;
                }
                int v = sc.nextInt();
                A[s].add(new Edge(e, v));
            }
        }
        BFS(1);
        int max = 0;
        for (int i = 2; i <= N; i++) {
            if (distance[max] < distance[i]) {
                max = i;
            }
        }

        visited = new boolean[N + 1];
        distance = new int[N + 1];
        BFS(max);

        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    public static void BFS(int s) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (Edge i : A[node]) {
                int e = i.e;
                int value = i.value;
                if (!visited[e]) {
                    q.add(e);
                    visited[e] = true;
                    distance[e] = distance[node] + value;
                }
            }
        }
    }

    public static class Edge {
        int e;
        int value;

        public Edge(int e, int value) {
            this.e = e;
            this.value = value;
        }
    }

}
