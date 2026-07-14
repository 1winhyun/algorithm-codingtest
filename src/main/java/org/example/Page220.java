package org.example;

import java.util.*;

public class Page220 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int[] nums = new int[B + 1];
        for (int i = A; i <= B; i++) {
            nums[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(B); i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i; j <= B; j = j + i) {
                if (nums[j] != i) {
                    nums[j] = 0;
                }
            }
        }


        int count = 0;
        for (int i = A; i <= B; i++) {
            if (nums[i] != 0 && nums[i] != 1) {
                int almostPrime = nums[i];
                while (almostPrime <= B) {
                    almostPrime = almostPrime * nums[i];
                    if(almostPrime<=B){
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
