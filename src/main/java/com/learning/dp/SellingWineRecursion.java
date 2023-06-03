package com.learning.dp;

public class SellingWineRecursion {
    public static int maxProfit(int[] wine, int year, int start, int end) {
        if (start == end) return wine[start] * year;
        int left = wine[start] * year + maxProfit(wine, year + 1, start + 1, end);
        int right = wine[end] * year + maxProfit(wine, year + 1, start, end - 1);
        return Math.max(left, right);
    }
    public static void main(String[] args) {

        int[] wine = {2, 4, 6, 2, 5};
        int year = 1;
        int start = 0;
        int end = wine.length - 1;

        int ans = maxProfit(wine, year, start, end);
        System.out.println("max profit is "+ ans);
    }

}
