package org.example;

import java.util.*;
import java.io.*;

public class Page81 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int number = 1;

        ArrayList<String> results = new ArrayList<>();
        boolean result = true;

        for (int i = 0; i < n; i++) {
            if (number <= numbers[i]) {
                while (number <= numbers[i]) {
                    stack.push(number);
                    number++;
                    results.add("+");
                }
                stack.pop();
                results.add("-");
            } else {
                int pop = stack.pop();
                if (pop > numbers[i]) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    results.add("-");
                }
            }
        }

        if (result) {
            for (int i = 0; i < results.size(); i++) {
                System.out.println(results.get(i));
            }
        }
    }
}
