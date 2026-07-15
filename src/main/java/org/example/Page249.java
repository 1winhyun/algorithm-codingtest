package org.example;

import java.util.*;

public class Page249 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        long maxYaksu = euclid(A, B);
        if (C % maxYaksu != 0) {
            System.out.println("-1");
        } else {
            int mok = (int) (C / maxYaksu);
            long[] answer = findAns(A, B);
            System.out.println(answer[0] * mok + " " + answer[1] * mok);
        }
    }

    public static long[] findAns(long a, long b) {
        long[] xy = new long[2];
        if (b == 0) {
            xy[0] = 1;
            xy[1] = 0;
            return xy;
        }
        long q = a / b;
        long[] next = findAns(b, a % b);
        xy[0] = next[1];
        xy[1] = next[0] - next[1] * q;
        return xy;
    }

    public static long euclid(long a, long b) {
        long big;
        long small;
        long remain;
        if (a > b) {
            big = a;
            small = b;
        } else {
            big = b;
            small = a;
        }

        while (big % small != 0) {
            remain = big % small;
            if (remain == 0) {
                break;
            }
            big = small;
            small = remain;
        }

        return small;
    }
}
