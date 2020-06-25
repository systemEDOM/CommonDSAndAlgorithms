package com.edom.algorithms.LeetCode;

public class Solution {
    public static void main(String[] args) {
        System.out.println(Solution.canWinNim(2));
        //System.out.println(Solution.hammingDistance(1, 5));
    }

    public static boolean canWinNim(int n) {
        return (n % 4 != 0);
    }

    public static int hammingDistance(int n1, int n2) {
        int x = n1 ^ n2;
        int setBits = 0;

        while (x > 0) {
            setBits += x & 1;
            x >>= 1;
        }

        return setBits;
    }
}
