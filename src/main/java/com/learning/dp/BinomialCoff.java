package com.learning.dp;

public class BinomialCoff {
    static int binomialCoeff(int n, int k)
    {
        if (k > n)
            return 0;
        if (k == 0 || k == n)
            return 1;

        return binomialCoeff(n - 1, k - 1)
                + binomialCoeff(n - 1, k);
    }

    static int binomialCoeffDP(int n, int k)
    {
        int C[][] = new int[n + 1][k + 1];
        int i, j;

        for (i = 0; i <= n; i++) {
            for (j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i)
                    C[i][j] = 1;
                else
                    C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
            }
        }
        return C[n][k];
    }

    public static void main(String[] args)
    {
        int n = 5, k = 2;
        System.out.printf("Value of C(%d, %d) is %d ", n, k,
                binomialCoeffDP(n, k));
    }
}
