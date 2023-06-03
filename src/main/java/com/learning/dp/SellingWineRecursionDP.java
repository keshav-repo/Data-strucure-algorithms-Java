/*
* Wine selling Problem
*
* */
package com.learning.dp;

import java.io.*;

class SellingWineRecursionDP {

    static int N = 1000;

    static int [][]dp = new int[N][N];

    // This array stores the "optimal action"
    // for each state i, j
    static int [][]sell = new int[N][N];

    // Function to maximize profit
    static int maxProfitUtil(int price[],
                             int begin, int end, int n)
    {
        if (dp[begin][end] != -1)
            return dp[begin][end];

        int year = n - (end - begin);

        if (begin == end)
            return year * price[begin];

        // x = maximum profit on selling the
        // wine from the front this year
        int x = price[begin] * year + maxProfitUtil(price, begin + 1, end, n);

        // y = maximum profit on selling the
        // wine from the end this year
        int y = price[end] * year + maxProfitUtil(price, begin, end - 1, n);

        int ans = Math.max(x, y);
        dp[begin][end] = ans;

        if (x >= y)
            sell[begin][end] = 0;
        else
            sell[begin][end] = 1;

        return ans;
    }

    // Util Function to calculate maxProfit
    static int maxProfit(int price[], int n)
    {

        // resetting the dp table
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                dp[i][j] = -1;

        int ans = maxProfitUtil(price, 0,
                n - 1, n);

        int i = 0, j = n - 1;

        while (i <= j) {

            // sell[i][j]=0 implies selling
            // the wine from beginning will
            // be more profitable in the
            // long run
            if(sell[i][j] == 0){
                System.out.print( "beg ");
                i++;
            }
            else
            {
                System.out.print( "end ");
                j--;
            }
        }

        System.out.println();

        return ans;
    }

    // Driver code
    public static void main (String[] args)
    {
        // Price array
        //int price[] = { 2, 4, 6, 2, 5 };

        int price[] = { 2, 4, 6, 5 };

        int n = price.length;

        int ans = maxProfit(price, n);

        for( int i=0; i<=n+1; i++){
            for(int j=0; j<=n+1; j++){
                System.out.print(dp[i][j] +" ");
            }
            System.out.println("");
        }
        for( int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(sell[i][j] +" ");
            }
            System.out.println("");
        }

        System.out.println( ans );
    }
}

// This code is contributed by anuj_67.
