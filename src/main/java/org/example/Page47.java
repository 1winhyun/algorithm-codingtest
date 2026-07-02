package org.example;

import java.util.*;

public class Page47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String start = sc.nextLine();
        String[] st = start.split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);

        int[][] xy = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String ar = sc.nextLine();
            String[] arrays = ar.split(" ");
            for (int j = 1; j <= N; j++) {
                xy[i][j] = Integer.parseInt(arrays[j - 1]);
            }
        }

        int[][] s = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + xy[i][j];
            }
        }

        int[][] geo = new int[3][4];
        for (int i = 0; i < M; i++) {
            String ar = sc.nextLine();
            String[] arrays = ar.split(" ");
            for (int j = 0; j < 4; j++) {
                geo[i][j] = Integer.parseInt(arrays[j]);
            }
        }

        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            result[i] = s[geo[i][2]][geo[i][3]] - s[geo[i][2]][geo[i][1] - 1] - s[geo[i][0] - 1][geo[i][3]] + s[geo[i][0] - 1][geo[i][1] - 1];
        }

        for (int i = 0; i < M; i++) {
            System.out.println(result[i]);
        }
    }
}
