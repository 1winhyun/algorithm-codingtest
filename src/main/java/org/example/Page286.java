package org.example;

import java.util.*;

public class Page286 {
    public static int[] city;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] connection = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                connection[i][j] = sc.nextInt();
            }
        }

        city = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            city[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (connection[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        int[] numbers = new int[m];
        for (int i = 0; i < m; i++) {
            numbers[i] = sc.nextInt();
        }
        String result = "YES";
        for (int i = 1; i < m; i++) {
            if (find(numbers[i]) != find(numbers[i - 1])) {
                result = "NO";
                break;
            }
        }

        System.out.println(result);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return;
        }
        if (city[a] > city[b]) {
            city[a] = b;
        } else if (city[a] < city[b]) {
            city[b] = a;
        }
    }

    public static int find(int a) {
        if (a == city[a]) {
            return a;
        }
        return find(city[a]);
    }

}
