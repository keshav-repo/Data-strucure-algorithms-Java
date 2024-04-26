package com.learning.array;

public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int maxPrice = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i]<minSoFar){
                minSoFar = prices[i];
            }
            if( (prices[i]-minSoFar)>maxPrice ){
                maxPrice =  prices[i]-minSoFar;
            }
        }
        return maxPrice;
    }
}
