package com.learning.dp;

import java.util.Arrays;

public class UniquePath {
    public static int uniquePathsUtil(int m, int n, int[][] dp) {
        if (dp[n][m] != -1)
            return dp[n][m];
        if (m == 1 || n == 1)
            return 1;
        return dp[n][m] = uniquePathsUtil(m - 1, n, dp) + uniquePathsUtil(m, n - 1, dp);
    }

    public static int uniquePaths(int m, int n) {
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return uniquePathsUtil(m, n, dp);
    }

    public static void main(String[] args) {
        int m = 3; // 51;
        int n = 7; //9;
        int ans = uniquePaths(m, n);
        System.out.println(ans);
    }
}
