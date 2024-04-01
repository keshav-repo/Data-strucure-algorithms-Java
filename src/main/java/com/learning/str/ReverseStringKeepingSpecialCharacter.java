package com.learning.str;

import java.util.Arrays;
import java.util.List;

public class ReverseStringKeepingSpecialCharacter {
    static String reverse(String input) {
        char[] arr = input.toCharArray();
        char[] rev = new char[arr.length];
        Arrays.fill(rev, '0');

        int revIdx = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (isAlphabatChar(arr[i])) {
                if (isSpecialCharacter(arr[revIdx])) {
                    revIdx++;
                }
                rev[revIdx++] = arr[i];
            } else {
                rev[i] = arr[i];
            }
        }

        return String.valueOf(rev);
    }

    private static List<Character> specialChar = List.of('$', '@', '!');

    static boolean isSpecialCharacter(char ch) {
        if (specialChar.contains(ch))
            return true;
        return false;
    }

    static boolean isAlphabatChar(char ch) {
        if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "@abc$d";//"abc$d";

        String ans = reverse(s);
        System.out.println(ans);

    }
}
