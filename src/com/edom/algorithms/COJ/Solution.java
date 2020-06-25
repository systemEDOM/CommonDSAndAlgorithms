package com.edom.algorithms.COJ;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(Solution.sumAB(a, b));
    }

    public static int sumAB(int a, int b) {
        return a + b;
    }
}
