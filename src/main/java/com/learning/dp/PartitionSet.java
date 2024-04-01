package com.learning.dp;

import java.io.*;

class PartitionSet
{
    public static int countP(int n, int k)
    {
        if (n == 0 || k == 0 || k > n)
            return 0;
        if (k == 1 || k == n)
            return 1;
        return (k * countP(n - 1, k)
                + countP(n - 1, k - 1));
    }

    static int countPDP(int n, int k)
    {
        
        int[][] dp = new int[n+1][k+1];

        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= k; i++)
            dp[0][k] = 0;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= k; j++)
                if (j == 1 || i == j)
                    dp[i][j] = 1;
                else
                    dp[i][j] = j * dp[i - 1][j] + dp[i - 1][j - 1];

        return dp[n][k];
    }
    
    public static void main(String args[])
    {
      

        int ans = countPDP(4,2);
        System.out.println(ans);

    }
}
