package org.example;

import java.util.*;

public class Page52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String start = sc.nextLine();
        String[] starts = start.split(" ");

        int N = Integer.parseInt(starts[0]);
        int M = Integer.parseInt(starts[1]);

        String numberString = sc.nextLine();
        String[] numberStrings = numberString.split(" ");
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(numberStrings[i]);
        }

        int allCount = ((N * N) + N) / 2;
        int[] s = new int[allCount + 1];
        s[0] = 0;
        int numberIndex = 0;
        int k = 1;
        int startChange = 0;
        for (int i = 1; i <= allCount; i++) {
            if (k == 1) {
                s[i] = s[k - 1] + numbers[numberIndex];
            } else {
                s[i] = s[i - 1] + numbers[numberIndex];
            }

            k = k + 1;
            numberIndex = numberIndex + 1;
            if (numberIndex >= N) {
                startChange = startChange + 1;
                numberIndex = startChange;
                k = 1;
            }
        }

        int count = 0;
        for (int i = 0; i < allCount; i++) {
            if (s[i] % M == 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
