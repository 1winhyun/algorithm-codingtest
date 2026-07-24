package org.example;

import java.util.*;

public class Page319 {
    public static int[] distance;
    public static boolean[] visited;
    public static ArrayList<node>[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        int start = sc.nextInt();

        distance = new int[V + 1];

        visited = new boolean[V + 1];
        A = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            visited[i] = false;
            A[i] = new ArrayList<>();
            if (i == start) {
                distance[i] = 0;
            } else {
                distance[i] = 100000000;
            }
        }

        for (int i = 1; i <= E; i++) {
            int startNode = sc.nextInt();
            int endNode = sc.nextInt();
            int weight = sc.nextInt();
            A[startNode].add(new node(endNode, weight));
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int nowNode = q.poll();
            for (node n : A[nowNode]) {
                int end = n.A;
                int weight = n.B;
                distance[end] = Math.min(distance[nowNode] + weight, distance[end]);
            }

            int min = 10000000;
            int minIndex = 1;
            for (int i = 1; i <= V; i++) {
                if (!visited[i] && distance[i] < min) {
                    min = distance[i];
                    minIndex = i;
                }
            }
            if (min == 10000000) {
                break;
            } else {
                q.add(minIndex);
                visited[minIndex] = true;
            }
        }

        for (int i = 1; i <= V; i++) {
            if (distance[i] == 100000000) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    public static class node {
        int A;
        int B;

        public node(int a, int b) {
            this.A = a;
            this.B = b;
        }
    }
}
