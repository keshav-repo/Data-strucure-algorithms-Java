package com.learning.str;

public class AllPerString {

    public static void main(String[] args) {
        String s = "cat";
        printallPermutns(s);
    }

    private static void printallPermutns(String str) {
        int slidingWinSize = 1;
        while (str.length() >= slidingWinSize) {
            for (int i = 0; i <= str.length() - slidingWinSize; i++) {
                String sub = str.substring(i, i + slidingWinSize);
                System.out.println(sub);
            }
            slidingWinSize++;
        }
    }
}
