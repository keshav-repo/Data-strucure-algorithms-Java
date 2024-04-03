package com.learning.dp;

import java.util.Stack;

public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0)
            return 0;
        int col = matrix[0].length;
        int max = 0;

        int dp[] = new int[col];
        for(int i=0; i<col; i++){
            dp[i] = matrix[0][i] == '1' ? 1: 0;
            max = largestRectangleHistogram(dp);
        }

        for (int i=1; i<row; i++) {
            for (int j=0; j<col; j++) {
                if(matrix[i][j]=='0'){
                    dp[j] = 0;
                }else{
                    dp[j] = dp[j]+1;
                }
            }
            max = Math.max(largestRectangleHistogram(dp), max);
        }
        return max;
    }
    public static int largestRectangleHistogram(int[] heights) {
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
        char arr[][] = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        int ans = maximalRectangle(arr);

        System.out.println(ans);
    }
}
