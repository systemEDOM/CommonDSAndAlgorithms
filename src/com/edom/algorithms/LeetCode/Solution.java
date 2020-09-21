package com.edom.algorithms.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        //System.out.println(Solution.canWinNim(2));
        //System.out.println(Solution.hammingDistance(1, 5));
        //System.out.println(Solution.groupThePeople(new int[] { 3,3,3,3,3,1,3 }));
        System.out.println(Solution.maxIncreaseKeepingSkyline(new int[][] {
                {3, 0, 8, 4},
                {2, 4, 5, 7},
                {9, 2, 6, 3},
                {0, 3, 1, 0}
        }));
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


    // key 3 = [0,1,2,3,4,6]
    // key 1 = [5]
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> buckets = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> currList = buckets.getOrDefault(groupSizes[i], new ArrayList<>());
            currList.add(i);
            buckets.put(groupSizes[i], currList);
        }

        for (int key : buckets.keySet()) {
            int i = 0;
            List<Integer> currbucket = buckets.get(key);
            while (i + key <= currbucket.size()) {
                result.add(currbucket.subList(i, i + key));
                i += key;
            }
        }

        return result;
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {
        int N = grid.length;
        int[] rowskyline = new int[N];
        int[] colskyline = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rowskyline[i] = Math.max(rowskyline[i], grid[i][j]);
                colskyline[j] = Math.max(colskyline[j], grid[i][j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int increaseHeight = Math.min(rowskyline[i], colskyline[j]) - grid[i][j];
                ans += increaseHeight;
            }
        }

        return ans;
    }
}
