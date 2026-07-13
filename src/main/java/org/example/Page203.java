package org.example;

import java.util.*;

public class Page203 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);

        PriorityQueue<Integer> minusQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> zeroQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (numbers[i] > 0) {
                plusQ.add(numbers[i]);
            } else if (numbers[i] < 0) {
                minusQ.add(numbers[i]);
            } else {
                zeroQ.add(numbers[i]);
            }
        }

        int minusSum = 0;
        if (minusQ.size() % 2 == 0) {
            while (!minusQ.isEmpty()) {
                int first = minusQ.remove();
                int second = minusQ.remove();

                minusSum = minusSum + (first * second);

                if (minusQ.isEmpty()) {
                    break;
                }
            }
        } else {
            if (zeroQ.isEmpty()) {
                minusSum = minusQ.remove();
                while (!minusQ.isEmpty()) {
                    int first = minusQ.remove();
                    int second = minusQ.remove();

                    minusSum = minusSum + (first * second);

                    if (minusQ.isEmpty()) {
                        break;
                    }
                }
            } else {
                minusSum = minusQ.remove() * zeroQ.remove();
                while (!minusQ.isEmpty()) {
                    int first = minusQ.remove();
                    int second = minusQ.remove();

                    minusSum = minusSum + (first * second);

                    if (minusQ.isEmpty()) {
                        break;
                    }
                }
            }
        }

        int plusSum = 0;
        while (!plusQ.isEmpty()) {
            int first = plusQ.remove();
            int second;
            if (!plusQ.isEmpty() && plusQ.peek() == 1) {
                second = plusQ.remove();
                plusSum = plusSum + (first + second);
            } else if (!plusQ.isEmpty() && plusQ.peek() != 1) {
                second = plusQ.remove();
                plusSum = plusSum + (first * second);
            } else {
                plusSum = plusSum + first;
            }
        }

        System.out.println(minusSum + plusSum);
    }
}
