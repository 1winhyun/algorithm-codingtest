package org.example;

import java.util.*;

public class Page304 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] buildings = new int[N + 1];
        ArrayList<Integer>[] A = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];
        int[] frontBuildingCount = new int[N + 1];
        int[] time = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            visited[i] = false;
        }

        for (int i = 1; i <= N; i++) {
            int frontBuilding = 0;
            buildings[i] = sc.nextInt();
            time[i] = buildings[i];
            while (frontBuilding != -1) {
                frontBuilding = sc.nextInt();
                if (frontBuilding == -1) {
                    break;
                }
                A[frontBuilding].add(i);
                frontBuildingCount[i] = frontBuildingCount[i] + 1;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (frontBuildingCount[i] == 0) {
                q.add(i);
                visited[i] = true;
                break;
            }
        }
        while (!q.isEmpty()) {
            int nowNode = q.poll();
            for (int i : A[nowNode]) {
                buildings[i] = Math.max(buildings[i], buildings[nowNode] + time[i]);
                frontBuildingCount[i] = frontBuildingCount[i] - 1;
            }

            for (int i = 1; i <= N; i++) {
                if (!visited[i] && frontBuildingCount[i] == 0) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(buildings[i]);
        }
    }
}
