package com.learning.str;

public class ReverseString {
    public static String revstr(String str)
    {
        return new StringBuilder(str).reverse().toString();
    }
    public static void main(String[] args)
    {
        String str= "Scaler by InterviewBit";
        str= revstr(str);
        System.out.println("Result after reversing a string is: "+ str);
    }
}
