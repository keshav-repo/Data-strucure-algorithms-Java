package com.learning.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];

        Arrays.fill(lis, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j] && lis[i] <= lis[j]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        int longestLen = lis[0];
        for (int i = 1; i < lis.length; i++) {
            if (lis[i] > longestLen)
                longestLen = lis[i];

        }
        return longestLen;
    }


    public static void main(String[] args) {
        int[] nums = {5, 8, 7, 1, 9};//{10, 9, 2, 5, 3, 7, 101, 18};

        int longLen = lengthOfLIS(nums);
        System.out.println(longLen);

    }
}
