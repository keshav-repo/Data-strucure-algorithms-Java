package com.learning.dp;

import java.util.Arrays;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
       boolean[] visited = new boolean[arr.length];
        Arrays.fill(visited, false);
       return canReachUtil(arr, start, visited);
    }

    public boolean canReachUtil(int[] arr, int start, boolean[] visited) {

        if(start<0 || start>=arr.length || visited[start]) return false;
        visited[start] = true;

        if(arr[start] == 0) return true;

        return canReachUtil(arr, start+arr[start], visited) || canReachUtil(arr, start-arr[start], visited);
    }

    public static void main(String[] args) {
        int[] arr = {3,0,2,1,2};// {4,2,3,0,3,1,2};
        int start = 2;
        JumpGameIII  jumpGame = new JumpGameIII();
        boolean ans = jumpGame.canReach(arr, start);
        System.out.println(ans);
    }
}
