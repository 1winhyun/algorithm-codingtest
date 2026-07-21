package org.example;

import java.util.*;

public class Page274 { // 꼭 다시 해보기
    public static int[] send = {0, 0, 1, 1, 2, 2};
    public static int[] get = {1, 2, 0, 2, 0, 1};
    public static boolean[][] visited;
    public static boolean[] answer;
    public static int[] now;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        now = new int[3];
        now[0] = sc.nextInt();
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();

        visited = new boolean[201][201];
        answer = new boolean[201];

        BFS();

        for (int i = 0; i < 201; i++) {
            if (answer[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void BFS() {
        Queue<AB> q = new LinkedList<>();
        q.add(new AB(0, 0));
        visited[0][0] = true;
        answer[now[2]] = true;

        while (!q.isEmpty()) {
            AB ab = q.poll();
            int a = ab.A;
            int b = ab.B;
            int c = now[2] - a - b;
            for (int i = 0; i < 6; i++) {
                int[] next = {a, b, c};
                next[get[i]] = next[get[i]] + next[send[i]];
                next[send[i]] = 0;

                if (next[get[i]] > now[get[i]]) {
                    next[send[i]] = next[get[i]] - now[get[i]];
                    next[get[i]] = now[get[i]];
                }

                if (!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.add(new AB(next[0], next[1]));
                    if (next[0] == 0) {
                        answer[next[2]] = true;
                    }
                }
            }
        }
    }

    public static class AB {
        int A;
        int B;

        public AB(int a, int b) {
            this.A = a;
            this.B = b;
        }
    }
}
