package com.learning.array;

public class SwapKthElements {
    public static void swapKth(int n, int k, int[] arr) {
        int temp = arr[k-1];
        arr[k-1] = arr[arr.length-k-1];
        arr[arr.length-k-1] = temp;
    }
    public static void main(String[] args) {

    }
}
