package Offer10_i;

class Solution {
    public int fib(int n) {
        int[] finums={0,1,1};
        for(int i=3;i<=n;i++){
            finums[i%3]=(finums[(i-1)%3]+finums[(i-2)%3])%1000000007;
        }
        return finums[n%3];
    }
}

public class Offer10 {
    
}
