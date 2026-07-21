package org.example;

import java.util.*;

public class Page269 {
    public static ArrayList<Integer>[] node;
    public static boolean[] visited;
    public static int[] result;
    public static boolean[] answers;
    public static boolean answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        answers = new boolean[K];

        for (int i = 0; i < K; i++) {
            int n = sc.nextInt();
            int e = sc.nextInt();

            node = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            result = new int[n + 1];

            for (int j = 1; j <= n; j++) {
                node[j] = new ArrayList<>();
            }

            for (int l = 0; l < e; l++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                node[a].add(b);
                node[b].add(a);
            }

            answer = true;
            for (int m = 1; m <= n; m++) {
                if (answer && !visited[m]) {
                    DFS(m);
                } else {
                    break;
                }
            }
            answers[i] = answer;
        }

        for (int i = 0; i < K; i++) {
            if (answers[i]) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static void DFS(int a) {
        visited[a] = true;
        if (result[a] == 0) {
            result[a] = 1;
        }
        for (int i : node[a]) {
            if (result[i] == result[a]) {
                answer = false;
                break;
            }
            if (!visited[i]) {
                visited[i] = true;
                if (result[i] == 0) {
                    if (result[a] == 1) {
                        result[i] = 2;
                    } else {
                        result[i] = 1;
                    }
                }
                DFS(i);
            }
        }
    }
}
