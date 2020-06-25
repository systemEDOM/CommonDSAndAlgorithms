package com.edom.algorithms.Own;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        //System.out.println(Solution.reverse("oracle"));

        //Solution.permutations(new int[] {1,2,3});
        Solution.combinations("abc");
    }

    //o(n)
    public static String reverse(String str) {
        char[] strArr = str.toCharArray();
        int n = strArr.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = strArr[i];
            strArr[i] = strArr[n - i -1];
            strArr[n - i - 1] = temp;
        }

        return new String(strArr);
    }

    public static void permutations(String str) {
        List<String> perms = new ArrayList<>();
        permutations(str.toCharArray(), 0, perms);
        System.out.println(perms);
    }

    public static void permutations(char[] str, int index, List<String> perms) {
        if (index == str.length) {
            perms.add(new String(str));
        } else {
            for (int i = index; i < str.length; i++) {
                swap(str, index, i);
                permutations(str, index + 1, perms);
                swap(str, index, i);
            }
        }
    }

    public static void permutations(int[] nums) {
        List<Integer> perms = new ArrayList<>();
        permutations(nums, 0, perms);
        System.out.println(perms);
    }

    public static void permutations(int[] nums, int index, List<Integer> perms) {
        if (index == nums.length) {
            StringBuilder currNum = new StringBuilder();
            for (int num : nums) currNum.append(num);
            perms.add(Integer.parseInt(currNum.toString()));
        } else {
            for (int i = index; i < nums.length; i++) {
                swap(nums, index, i);
                permutations(nums, index + 1, perms);
                swap(nums, index, i);
            }
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void combinations(String str) {
        StringBuilder strOutput = new StringBuilder();
        combinations(str, 0, strOutput);
    }

    public static void combinations(String str, int index, StringBuilder strOutput) {
        for (int i = index; i < str.length(); i++) {
            strOutput.append(str.charAt(i));
            System.out.println(strOutput);
            combinations(str, i + 1, strOutput);
            strOutput.setLength(strOutput.length() - 1);
        }
    }
}
