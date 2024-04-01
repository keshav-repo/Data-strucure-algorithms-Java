package com.learning.dp;

import java.util.Arrays;

public class HouseRobberII {

   /* public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        int length = nums.length - 1;
        Arrays.fill(dp, -1);

        //rob from 1st house
        int rob1 = robUtil(0, length - 1, nums, dp);
        // rob from 2nd house
        int rob2 = robUtil(1, length, nums, dp);

        for (int i = 0; i < dp.length; i++)
            System.out.print(dp[i] + " ");
        System.out.println("");

        return rob1 > rob2 ? rob1 : rob2;
    }

    private int robUtil(int start, int end, int[] nums, int[] dp) {
        if (start > end)
            return 0;

        if (dp[start] != -1)
            return dp[start];

        int rob1 = nums[start] + robUtil(start + 2, end, nums, dp);
        int rob2 = nums[start] + robUtil(start + 3, end, nums, dp);

        dp[start] = rob1 > rob2 ? rob1 : rob2;
        return dp[start];
    }*/

    public int rob(int[] nums) {
        int n = nums.length;
        int rob1 = robRange(nums, 0, n - 2);
        int rob2 = robRange(nums, 1, n - 1);

        return Math.max(rob1,rob2);
    }

    private int robRange(int[] nums, int start, int end) {
        int a = 0;
        int b = nums[start];
        for (int i = start + 1; i <= end; i++) {
            int temp = Math.max(a + nums[i], b);
            a = b;
            b = temp;
        }
        return b;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        HouseRobberII houseRobber = new HouseRobberII();
        int ans = houseRobber.rob(nums);
        System.out.println(ans);
    }
}
