package com.learning.srh;
public class PeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;

        if(nums.length==2){
            return nums[0] > nums[1] ? 0 : 1;
        }

        int prev = Integer.MIN_VALUE;
        int curr =0, next=0;
        for(int i=0; i<nums.length-1; i++){
            curr = nums[i];
            next = nums[i+1];
            if( curr > prev && curr > next  )
                return i;
        }
        return next > curr ? nums.length-1: nums.length-2;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};

        PeakElement peakElement = new PeakElement();
        int ans = peakElement.findPeakElement(nums);
        System.out.println(ans);
    }
}
