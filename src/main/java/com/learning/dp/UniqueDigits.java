package com.learning.dp;

public class UniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            dp[i] = digitCount(i)+dp[i-1];
        }
        return dp[n];
    }

    private int digitCount(int n){
        if(n==1)
            return 9;
        else
            return (9-n+2)*digitCount(n-1);
    }

    public static void main(String[] args) {
        UniqueDigits uniqueDigits = new UniqueDigits();
        int ans = uniqueDigits.countNumbersWithUniqueDigits(2);
        System.out.println(ans);
    }
}
