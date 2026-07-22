package org.example;

import java.util.*;

public class Page291 {
    public static int[] people;
    public static ArrayList<Integer>[] party;
    public static int[] truth;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        people = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            people[i] = i;
        }

        int truthCount = sc.nextInt();
        truth = new int[truthCount];
        for (int i = 0; i < truthCount; i++) {
            truth[i] = sc.nextInt();
        }

        party = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
            int partyPeople = sc.nextInt();
            for (int j = 0; j < partyPeople; j++) {
                party[i].add(sc.nextInt());
            }
            if (party[i].size() > 1) {
                for (int k = 1; k < partyPeople; k++) {
                    union(party[i].get(k - 1), party[i].get(k));
                }
            }
        }

        int resultCount = 0;
        boolean canTellTruth;
        for (int i = 0; i < party.length; i++) {
            if (party[i].isEmpty()) {
                resultCount++;
                continue;
            }
            int find = find(party[i].getFirst());
            canTellTruth = true;
            for (int j = 0; j < truth.length; j++) {
                if (find == find(truth[j])) {
                    canTellTruth = false;
                    break;
                }
            }
            if (canTellTruth) {
                resultCount++;
            }
        }

        System.out.println(resultCount);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return;
        }

        if (people[a] < people[b]) {
            people[b] = a;
        } else if (people[a] > people[b]) {
            people[a] = b;
        }
    }

    public static int find(int a) {
        if (a == people[a]) {
            return a;
        }
        return find(people[a]);
    }
}
