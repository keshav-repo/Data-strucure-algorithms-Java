package com.learning.str;

public class LicenseKeyFormatting {
    static String format(String s, int k) {
        char[] arr = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        int i = 0;
        while (arr[i] != '-') {
            builder.append(Character.toUpperCase(arr[i]));
            i++;
        }
        int count = 0;
        for (int j = i; j < arr.length; j++) {
            if (arr[j] == '-' && count == 0) {
                builder.append(Character.toUpperCase(arr[j]));
            } else if (arr[j] == '-' && count != 0) {
                // do nothing
            } else {
                builder.append(Character.toUpperCase(arr[j]));
                count++;
                if (count == k) {
                    count = 0;
                }
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        String S = "2-5g-3-J";//"5F3Z-2e-9-w";
        int K = 2; //4;

        System.out.println(format(S, K));

    }
}
