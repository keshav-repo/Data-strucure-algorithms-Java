package com.learning.random;

public class SmallestSumSubarray {

    public static int minSubArraySum(int[] arr, int sum) {
        int start = 0;
        int end = 0;
        int resMinSum = Integer.MAX_VALUE;
        int currMinSum = 0;
        int size = arr.length;
        while (end < size) {
            while (currMinSum <= sum && end < size) {
                currMinSum += arr[end++];
            }
//            System.out.println("current min sum "+currMinSum);
            while (currMinSum > sum && start < size) {
                if (resMinSum > currMinSum) {
                    resMinSum = currMinSum;
                }
                currMinSum -= arr[start++];
            }
        }
//        System.out.println("current min sum: " + resMinSum);
//        System.out.println("start " + start + " end " + end);

        return resMinSum;
    }

    public static void printArr(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        int arr[][] = {{1, 4, 45, 6, 0, 19},  { 1, 10, 5, 2, 7 }, { 1, 11, 100, 1, 0, 200, 3, 2, 1, 250 } };
        int[] target = {51, 9, 280};
        int ans[] = {55,10, 301};
        for(int i=0; i<target.length; i++){
           int res =  minSubArraySum(arr[i], target[i]);
           if(res!=ans[i]){
               System.out.println("Wrong answer for ");
               printArr(arr[i]);
               System.out.println("expected answer "+ ans[i]);
               System.out.println("answer returned "+res);
               break;
           }
        }
    }
}


/*

{1, 4, 45, 6, 0, 19}
51

{ 1,1,1,2,3,6,9,10 }

9



* */