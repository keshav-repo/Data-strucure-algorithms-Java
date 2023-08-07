package com.learning.str;

public class Atoi {
    static int getInt(String s) {
        char[] arr = s.toCharArray();
        long resNum = 0;
        boolean isNegative = false;
        boolean isPlusChar = false;
        boolean characterBeforeInteger = false;
        boolean previousAlphabat = false;
        int maxInt = (int) Math.pow(2, 31);
        char prev = '\u0000';
        for (int i = 0; i < arr.length; i++) {
//            if ((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'A' && arr[i] <= 'Z')) {
//                if (resNum == 0)
//                    continue;
//                else
//                    return 0;
//            }
            if (arr[i] == '.') {
                return (int) resNum;
            }
            if (arr[i] == '+') {
                isPlusChar = true;
                continue;
            }
            if (arr[i] == ' ')
                continue;
            if (arr[i] == '-') {
                isNegative = true;
                continue;
            }
            if (isNegative && isPlusChar)
                return 0;
            if(Character.isAlphabetic(arr[i])){
                previousAlphabat = true;
                continue;
            }else if( Character.isDigit(arr[i]) && previousAlphabat){
                return 0;
            }
            else if(Character.isDigit(arr[i])){
                resNum = resNum * 10 + (arr[i] - '0');
                previousAlphabat = false;
            }
        }
        if (isNegative) {
            if (resNum > maxInt) {
                return maxInt * -1 - 1;
            } else {
                return (int) resNum * -1;
            }
        } else {
            if (resNum > maxInt) {
                return maxInt;
            } else {
                return (int) resNum;
            }
        }
    }

    public static void main(String[] args) {
        String[] input = {"words and 987", "-91283472332", "3.14159", "+-12", "+", "4193", "00000-42a1234", "4193 with words", "  -0012a42"};
        int[] expected = {0, -2147483648, 3, 0, 0, 4193, 0, 4193, -12};
        for (int i = 0; i < input.length; i++) {
            int actual = getInt(input[i]);
            if (actual != expected[i]) {
                System.out.println("Result not matching for input: " + input[i] + " Expected " + expected[i] + " actual " + actual);
            }
        }

    }
}
