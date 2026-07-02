package org.example;

import java.util.*;

public class Page35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String countString = sc.nextLine();
        String numberString = sc.nextLine();

        int count = Integer.parseInt(countString);
        String[] n = numberString.split("");
        int[] number = new int[numberString.length()];
        for (int i = 0; i < numberString.length(); i++) {
            number[i] = Integer.parseInt(n[i]);
        }

        int result = 0;
        for (int i = 0; i < number.length; i++) {
            result += number[i];
        }

        System.out.println(result);
    }
}