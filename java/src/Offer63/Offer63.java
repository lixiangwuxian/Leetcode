package Offer63;

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        if(prices.length==0){
            return 0;
        }
        int minPrice=prices[0];
        for(int i:prices){
            if(minPrice>i){
                minPrice=i;
            }
            maxProfit=max(maxProfit,i-minPrice);
        }
        return maxProfit;
    }
    int max(int a,int b){
        if(a>b){
            return a;
        }
        return b;
    }
}

public class Offer63 {
    
}
