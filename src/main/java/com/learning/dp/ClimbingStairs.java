package com.learning.dp;

import java.util.Arrays;

public class ClimbingStairs {
    public static int climbStairsUtil(int n, int[] dp) {
        if(n<=1)
            return 1;
        if(dp[n]!=-1)
            return dp[n];
        return dp[n] = climbStairsUtil(n-1, dp)+climbStairsUtil(n-2, dp);
    }

    public static int climbStairs(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climbStairsUtil(n, dp);
    }

    public static void main(String[] args) {
        int n = 45;
        int steps = climbStairs(45);
        System.out.println(steps);
    }
}
