package org.example;

import java.util.*;

public class Page211 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sik = sc.nextLine();
        String[] splitSik = sik.split("-");

        int result = 0;

        String[] plusSik = splitSik[0].split("[+]");
        for (int i = 0; i < plusSik.length; i++) {
            result = result + Integer.parseInt(plusSik[i]);
        }

        for (int i = 1; i < splitSik.length; i++) {
            String[] minusSik = splitSik[i].split("[+]");
            for (int j = 0; j < minusSik.length; j++) {
                result = result - Integer.parseInt(minusSik[j]);
            }
        }

        System.out.println(result);
    }
}
