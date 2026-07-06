package org.example;

import java.util.Scanner;

public class Page108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N = sc.nextLine();

        String[] numbers = N.split("");
        int[] number = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            number[i] = Integer.parseInt(numbers[i]);
        }

        int max;
        int temp;
        int maxIndex = 0;
        for (int i = 0; i < number.length; i++) {
            max = 0;
            int j;
            for (j = i; j < number.length; j++) {
                if (max < number[j]) {
                    maxIndex = j;
                    max = number[j];
                }
            }
            temp = number[i];
            number[i] = max;
            number[maxIndex] = temp;
        }

        for (int i = 0; i < number.length; i++) {
            System.out.print(number[i]);
        }
    }
}
