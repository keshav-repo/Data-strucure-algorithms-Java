package com.learning.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void swap(int left, int right, int[] arr) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static List<Integer> getList(int[] arr) {
        List<Integer> list = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }

    public static void permute(int left, int right, int[] num, List<List<Integer>> res) {
        if (left == right) {
            res.add(getList(num));
        } else {
            // swap left, right one by one
            for (int i = left; i <= right; i++) {
                swap(left, i, num);
                permute(left + 1, right, num, res);
                swap(left, i, num);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permute(0, nums.length - 1, nums, res);
        return res;
    }

    public static void main(String[] args) {
       int[] nums = {1,2,3};
        Permutations pe = new Permutations();
        System.out.println(pe.permute(nums));
    }

}
