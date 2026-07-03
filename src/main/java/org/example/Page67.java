package org.example;

import java.util.*;

public class Page67 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String NM = sc.nextLine();
        String[] nm = NM.split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        String dnaString = sc.nextLine();
        String[] dna = dnaString.split("");

        String countStrings = sc.nextLine();
        String[] countString = countStrings.split(" ");
        int[] count = new int[4];
        for (int i = 0; i < 4; i++) {
            count[i] = Integer.parseInt(countString[i]);
        }

        int result = 0;
        int dnaCount = 0;

        int[] checkArr = new int[4];
        for (int i = 0; i < M; i++) {
            if (dna[i].equals("A")) {
                checkArr[0]++;
            } else if (dna[i].equals("C")) {
                checkArr[1]++;
            } else if (dna[i].equals("G")) {
                checkArr[2]++;
            } else {
                checkArr[3]++;
            }
        }


        for (int i = 0; i < 4; i++) {
            if (checkArr[i] >= count[i]) {
                dnaCount = dnaCount + 1;
            }
        }

        if (dnaCount == 4) {
            result++;
        }

        int j = 0;
        for (int i = M; i < N; i++) {
            if (dna[j].equals("A")) {
                checkArr[0]--;
                if (checkArr[0] < count[0]) {
                    dnaCount--;
                }
            } else if (dna[j].equals("C")) {
                checkArr[1]--;
                if (checkArr[1] < count[1]) {
                    dnaCount--;
                }
            } else if (dna[j].equals("G")) {
                checkArr[2]--;
                if (checkArr[2] < count[2]) {
                    dnaCount--;
                }
            } else {
                checkArr[3]--;
                if (checkArr[3] < count[3]) {
                    dnaCount--;
                }
            }

            if (dnaCount < 0) {
                dnaCount = 0;
            }

            if (dna[i].equals("A")) {
                checkArr[0]++;
                if (checkArr[0] >= count[0]) {
                    dnaCount++;
                }
            } else if (dna[i].equals("C")) {
                checkArr[1]++;
                if (checkArr[1] >= count[1]) {
                    dnaCount++;
                }
            } else if (dna[i].equals("G")) {
                checkArr[2]++;
                if (checkArr[2] >= count[2]) {
                    dnaCount++;
                }
            } else {
                checkArr[3]++;
                if (checkArr[3] >= count[3]) {
                    dnaCount++;
                }
            }

            if (dnaCount == 4) {
                result++;
            }

            j++;
        }

        System.out.println(result);
    }
}
