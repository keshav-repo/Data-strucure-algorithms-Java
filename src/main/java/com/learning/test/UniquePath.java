package com.learning.test;

public class UniquePath {
    public int uniquePaths(int m, int n) {
        if(m==1 || n==1)
            return 1;
        int c1 = uniquePaths(m-1, n);
        int c2 = uniquePaths(m, n-1);
        return c1+c2;
    }

    public int uniquePathsUtils(int m, int n, int x){
        return 0;
    }

    public static void main(String[] args) {
        int  m = 3, n = 7;
        UniquePath uniquePath = new UniquePath();
        int ans = uniquePath.uniquePaths(m, n);
        System.out.println(ans);
    }
}
