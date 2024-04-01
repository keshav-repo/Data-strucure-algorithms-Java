package com.learning.str;

import java.util.Arrays;

public class ArrayToString {
    public static void main(String[] args)
    {
        String[] strArray = { "Scaler", "by", "InterviewBit"};
        String str1 = ConvertArraytoString(strArray);
        System.out.println("An array converted to a string: " + str1);
    }
    public static String ConvertArraytoString(String[] strArray)
    {
        return Arrays.toString(strArray);
    }
}
