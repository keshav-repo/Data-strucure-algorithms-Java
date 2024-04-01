package com.learning.random;

public class MartinJogging {
    public static int[] solve(int x1, int x2, int v1, int n){
        int[] result = new int[2];
        int[] steps = new int[n+1];
        for (int i=0; i<=n; i++)
            steps[i] = x1 + v1*i - x2;

        for(int i=0; i<=n; i++){
            if(steps[i]<=0) continue;
            int v2 = steps[i];
            int count = 0;
            for(int j=i; j<=n; j++){
                if(steps[j]%v2 == 0)
                    count++;
            }
            if(result[0]<=count){
                result[0] = count;
                result[1] = v2;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] res = solve(3,2,2,20);
        //solve(13,5,9,4);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
