package org.example;

import java.util.*;

public class Page300 {
    public static ArrayList<Integer>[] A;
    public static int[] node;
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        node = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            visited[i] = false;
        }


        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            A[a].add(b);
            node[b]++;
        }

        int[] result = new int[N];
        int resultIndex = 0;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (node[i] == 0 && !visited[i]) {
                q.add(i);
                visited[i] = true;
            }
        }
        while (!q.isEmpty()) {
            int nowNode = q.poll();
            result[resultIndex] = nowNode;
            resultIndex++;
            for (int j : A[nowNode]) {
                node[j] = node[j] - 1;
                if (node[j] == 0 && !visited[j]) {
                    q.add(j);
                    visited[j] = true;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
