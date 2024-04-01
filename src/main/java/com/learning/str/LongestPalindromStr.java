package com.learning.str;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromStr {
    public static String getAllSubsetInString(String str) {

        int slidingWinSize = 1;
        int longestSubLen = Integer.MIN_VALUE;
        String longestSub = "";
        String sub = "";
        Map<Character, Boolean> map = new HashMap<>(str.length());
        int start = 0;
        int end = 0;
        int size = 0;
        while (str.length() >= slidingWinSize) {
            for (int i = 0; i < str.length(); i++) {
                if ((i + slidingWinSize) <= str.length()) {
                    size = i + slidingWinSize + 1;
                    sub = str.substring(i, i + slidingWinSize);
                    System.out.println(sub);

                }
            }
            slidingWinSize++;
        }
        return "";
    }

    // chat gpt solution
    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // For odd-length palindromes
            int len2 = expandAroundCenter(s, i, i + 1); // For even-length palindromes

            int len = Math.max(len1, len2);

            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    /*
     * bab -> a
     * set -> if size = 1 -> palindrom
     *
     *
     * */
    public static void main(String[] args) {
        String str = "babad";

        String res = longestPalindrome2(str);
        System.out.println(res);
    }
}






