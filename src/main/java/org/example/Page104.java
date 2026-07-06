package org.example;

import java.util.*;

public class Page104 { // 책에 있는 풀이대로 다시 풀어보기. 무슨 말인지 이해가 안되어서 다른 방법으로 풀었음.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        int count = 0;
        boolean changed = false;
        int k = 1;
        int middle;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 1; j < N; j++) {
                if (numbers[k - 1] > numbers[k]) {
                    middle = numbers[k - 1];
                    numbers[k - 1] = numbers[k];
                    numbers[k] = middle;
                    changed = true;
                }
                k++;
            }
            k = 1;
            if (changed) {
                count++;
                changed = false;
            } else {
                count++;
                break;
            }
        }

        System.out.println(count);
    }
}
