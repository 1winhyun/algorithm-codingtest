package org.example;

import java.util.*;

public class Page169 {
    public static int[][] A;
    public static boolean[][] visited;
    public static int N;
    public static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String NM = sc.nextLine();
        String[] stringNM = NM.split(" ");

        N = Integer.parseInt(stringNM[0]);
        M = Integer.parseInt(stringNM[1]);

        A = new int[N][M];
        visited = new boolean[N][M];

        String[] stringA = new String[N * M];
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            stringA = s.split("");
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(stringA[j]);
            }
        }

        BFS(0, 0);
        System.out.println(A[N - 1][M - 1]);
    }

    public static void BFS(int a, int b) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{a, b});
        visited[a][b] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int[] changeX = new int[]{0, 1, 0, -1};
            int[] changeY = new int[]{1, 0, -1, 0};
            for (int i = 0; i < 4; i++) {
                int x = now[0] + changeX[i];
                int y = now[1] + changeY[i];
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (A[x][y] == 1 && !visited[x][y]) {
                        A[x][y] = A[now[0]][now[1]] + 1;
                        visited[x][y] = true;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }
    }
}
