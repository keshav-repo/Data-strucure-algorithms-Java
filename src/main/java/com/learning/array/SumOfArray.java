package com.learning.array;

public class SumOfArray {
    int sum(int arr[], int n) {
        int res = 0;
        for(int i=0; i<arr.length; i++){
            res += arr[i];
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
