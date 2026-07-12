package org.example;

import java.util.*;

public class Page191 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int k = sc.nextInt();

        int start = 1;
        int end = k;

        int sum = 0;
        int result = 0;
        while (start <= end) {
            int middle = (start + end) / 2;
            for (int i = 1; i <= N; i++) {
                int count;
                if (middle / i > N) {
                    count = N;
                } else {
                    count = middle / i;
                }
                sum = sum + count;
            }
            if (sum < k) {
                start = middle + 1;
            } else {
                result = middle;
                end = middle - 1;
            }
            sum = 0;
        }
        System.out.println(result);
    }
}
