package com.learning.dp;

import java.util.Arrays;

public class HouseRobber {
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        //rob from 1st house
        int rob1 = robUtil(0, nums, dp);
        // rob from 2nd house
        int rob2 = robUtil(1, nums, dp);

        for(int i=0; i<dp.length; i++)
            System.out.print(dp[i]+" ");
        System.out.println("");

        return rob1 > rob2 ? rob1 : rob2;
    }

    private static int robUtil(int start, int[] nums, int[] dp) {
        if(start>=nums.length)
            return 0;

        if(dp[start] != -1)
            return dp[start];

        int rob1 = nums[start]+ robUtil(start+2, nums, dp);
        int rob2 = nums[start] + robUtil(start+3, nums, dp);

        dp[start] = rob1 > rob2 ? rob1 : rob2;
        return dp[start];
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 1, 2}; // {1,2,3,1};//{2,7,9,3,1};

        int ans = rob(nums);

        System.out.println(ans);
    }
}
