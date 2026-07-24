package org.example;

import java.util.*;

public class Page325 {
    public static ArrayList<Node>[] A;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] costs = new int[N + 1];
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];


        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            visited[i] = false;
        }

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int cost = sc.nextInt();
            A[start].add(new Node(end, cost));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            if (i == start) {
                costs[i] = 0;
            } else {
                costs[i] = 100000000;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int nowNode = q.poll();
            for (Node n : A[nowNode]) {
                int endNode = n.A;
                int weight = n.B;
                costs[endNode] = Math.min(costs[nowNode] + weight, costs[endNode]);
            }

            int min = 100000000;
            int minIndex = 1;
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && costs[i] < min) {
                    minIndex = i;
                    min = costs[i];
                }
            }

            if (min == 100000000) {
                break;
            } else {
                q.add(minIndex);
                visited[minIndex] = true;
            }
        }

        System.out.println(costs[end]);
    }

    public static class Node {
        int A;
        int B;

        public Node(int a, int b) {
            this.A = a;
            this.B = b;
        }
    }
}
