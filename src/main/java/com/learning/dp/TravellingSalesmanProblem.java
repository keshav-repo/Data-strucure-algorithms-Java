package com.learning.dp;


import java.io.*;
import java.util.*;

public class TravellingSalesmanProblem {
    static int n = 4;
    static int MAX = 1000000;
    static int[][] dist = {
            {0, 0, 0, 0, 0}, {0, 0, 10, 15, 20},
            {0, 10, 0, 25, 25}, {0, 15, 25, 0, 30},
            {0, 20, 25, 30, 0},
    };
    static int[][] memo = new int[n + 1][1 << (n + 1)];

    static int fun(int i, int mask) {

        if (mask == ((1 << i) | 3))
            return dist[1][i];

        if (memo[i][mask] != 0)
            return memo[i][mask];

        int res = MAX;

        for (int j = 1; j <= n; j++) {
            if ((mask & (1 << j)) != 0 && j != i && j != 1) {
                int y = ~(1 << i);
                int x = fun(j, mask & y);
                res = Math.min(res, x + dist[j][i]);
            }
        }

        return memo[i][mask] = res;
    }


    public static void main(String[] args) {
        int ans = MAX;

        int val = 1 << (n + 1);

        System.out.println(val);

        for (int i = 1; i <= n; i++){
            int mask = (1 << (n + 1));
            ans = Math.min(ans, fun(i, mask - 1) + dist[i][1]);
        }


        System.out.println(
                "The cost of most efficient tour = " + ans);

    }
}


