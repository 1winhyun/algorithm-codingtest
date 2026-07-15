package org.example;

import java.util.*;

public class Page241 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        long remain;
        long yaksu;
        long big;
        long small;
        if (A > B) {
            big = A;
            small = B;
        } else {
            big = B;
            small = A;
        }

        while (true) {
            remain = big % small;
            if (remain == 0) {
                yaksu = small;
                break;
            }
            if (remain > small) {
                big = remain;
            } else {
                big = small;
                small = remain;
            }
        }

        StringBuilder result = new StringBuilder();
        for (long i = 0; i < yaksu; i++) {
            result.append("1");
        }

        System.out.println(result);
    }
}
