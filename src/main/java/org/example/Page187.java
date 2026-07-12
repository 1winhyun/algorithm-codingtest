package org.example;

import java.util.*;

public class Page187 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] br = new int[N];
        int[] findMin = new int[N];
        int end = 0;
        for (int i = 0; i < N; i++) {
            br[i] = sc.nextInt();
            end = end + br[i];
            findMin[i] = br[i];
        }

        Arrays.sort(findMin);
        int start = findMin[findMin.length - 1];

        while (start <= end) {
            int brCount = 0;
            int middle = (start + end) / 2;
            int length = 0;
            for (int i = 0; i < N; i++) {
                if (length + br[i] > middle) {
                    brCount++;
                    length = 0;
                }
                length = length + br[i];
            }
            if (length > 0) {
                brCount++;
            }

            if (brCount > M) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        System.out.println(start);
    }
}
