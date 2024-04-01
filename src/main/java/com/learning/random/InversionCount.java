package com.learning.random;

public class InversionCount {


    public static void sort(int[] arr, int start, int end){
        while (start<end){

            int mid = (start+end)/2;

            sort(arr, start, mid);
            sort(arr, mid+1, end);

            merge(arr, start, mid, end);
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int size1 = mid-start+1;
        int size2 = end-mid;

        int[] left = new int[size1];
        int[] right = new int[size2];

        for(int i=0; i<size1; i++)
            left[i] = arr[start+i];
        for(int i=0; i<size2; i++)
            right[i]=arr[mid+i];






    }

    public static void main(String[] args) {
        // int arr[] = {8, 4, 2, 1};
//        int[] arr = {1, 20, 6, 4, 5};

        int[] arr = {1, 3, 6, 4, 5};



//        int[] smallerCount = new int[arr.length];
//        for (int i = arr.length - 1; i >= 1; i--) {
//            if (arr[i] < arr[i - 1]) {
//                if (i == (arr.length - 1)) {
//                    smallerCount[i] = 1;
//                } else {
//                    smallerCount[i] = smallerCount[i + 1] + 1;
//                }
//            }else {
//                smallerCount[i] = smallerCount[i+1];
//            }
//        }
//        for (int i = 0; i < smallerCount.length; i++) {
//            System.out.print(smallerCount[i] + " ");
//        }

    }
}
