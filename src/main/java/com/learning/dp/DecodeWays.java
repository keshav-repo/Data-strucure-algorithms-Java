package com.learning.dp;

public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) =='0'?0:1;
        for(int i=2; i<=s.length(); i++){
            int d = s.charAt(i-1)-'0';
            int dd = 10*(s.charAt(i-2)-'0')+(s.charAt(i-1)-'0');

            if(d>0)  dp[i] += dp[i-1];
            if(dd>=10 && dd <= 26) dp[i] += dp[i-2];
        }

        return dp[s.length()];
    }
    public static void main(String[] args) {
        String s = "11106";
        DecodeWays decodeWays = new DecodeWays();
       int ans =  decodeWays.numDecodings(s);
        System.out.println(ans);
    }
}
