package com.learning.array;

public class TrappingRainWater {
    public int trap(int[] height) {
        int[] maxRight = new int[height.length];
        int[] maxLeft = new int[height.length];

        int max = height[height.length-1];
        for(int i=height.length-1; i>=0; i--){
            if(height[i]>max){
                max = height[i];
            }
            maxRight[i] = max;
        }
        max = height[0];
        for(int i=0; i<height.length; i++){
            if(height[i]>max){
                max = height[i];
            }
            maxLeft[i] = max;
        }
        int waterUnits = 0;
        for(int i=0; i<height.length; i++){
            waterUnits += Math.abs( Math.min(maxLeft[i],maxRight[i]) ) - height[i];
        }
        return waterUnits;
    }
}
