package com.learning.array;

import java.util.ArrayList;

public class ValueEqualToIndex {
    ArrayList<Integer> valueEqualToIndex(int arr[], int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if((i+1)==arr[i]){
                res.add(i+1);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {15, 2, 45, 12, 7};

    }
}
