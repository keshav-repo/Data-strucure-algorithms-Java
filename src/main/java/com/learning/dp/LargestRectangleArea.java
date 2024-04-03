package com.learning.dp;

import java.util.Stack;

public class LargestRectangleArea {
    public static int largestRectangleArea(int[] heights) {
        int prevSmaller[] = new int[heights.length];
        int nextSmaller[] = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<heights.length; i++){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                prevSmaller[i] = -1;
            }else {
                prevSmaller[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i=heights.length-1; i>=0; i--){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextSmaller[i] = heights.length;
            }else {
                nextSmaller[i] = stack.peek();
            }
            stack.push(i);
        }
        int maxArea = Integer.MIN_VALUE;
        for(int i=0; i<heights.length; i++){
            int area = (nextSmaller[i]-prevSmaller[i]-1)*heights[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int arr[] = {6,2,5,4,5,1,6};//{2,1,5,6,2,3};
        int res = largestRectangleArea(arr);
        System.out.println(res);
    }
}
