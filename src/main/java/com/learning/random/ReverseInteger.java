package com.learning.random;

public class ReverseInteger {
    public static int reverse(int x) {
        int higherRange = (int)Math.pow(2,31)-1;
        int lowerRange = (int)Math.pow(-2,31);

        long rev = 0;
        while(x!=0){
            int rem = x % 10;
            rev = rev*10+rem;
            x = x/ 10;
        }
        if (rev > higherRange || rev < lowerRange)
            return 0;

        return (int)rev;
    }

    // Code using 32 bit integer
    public static int reverse2(int x) {
        int higherRange = (int)Math.pow(2,31)-1;
        int lowerRange = (int)Math.pow(-2,31);

        int rev = 0;
        while(x!=0){
            if(rev > higherRange/10 || rev < lowerRange /10)
                return 0;
            int rem = x % 10;
            rev = rev*10+rem;
            x = x/ 10;
        }
        return rev;
    }
    public static void main(String[] args) {
        int ans = reverse2(1534236469);  // 1534236469, 123
        System.out.println(ans);
    }
}
