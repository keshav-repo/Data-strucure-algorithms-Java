package com.learning.str;


public class LongestCommonSub2 {
    static int lcs(String X, String Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(L[i][j] + " ");
            }
            System.out.println("");
        }

        int res = L[m][n];

        StringBuilder builder = new StringBuilder();
        while (m >= 1 && n >= 1) {
            System.out.println("m,n "+m+","+n);
            int curr = L[m][n];
            int left = L[m][n - 1];
            int upper = L[m - 1][n];
            System.out.println("current, left, upper "+curr+" "+left+" "+upper);
            if (curr > left && curr > upper) {
                builder.append(X.charAt(m - 1));
                m--;
                n--;
            } else if (left > upper) {
               // m--;
                n--;
            } else {
                //n--;
                m--;
            }
        }

        System.out.println("Subsequence is ".concat(builder.reverse().toString()));

        return res;
    }

    public static void main(String[] args) {
        String S1 = "AGGTAB";
        String S2 = "GXTXAYB";
        int m = S1.length();
        int n = S2.length();

        System.out.println("Length of LCS is " + lcs(S1, S2, m, n));
    }
}
