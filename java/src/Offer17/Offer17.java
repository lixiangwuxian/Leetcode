package Offer17;

import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public int[] printNumbers(int n) {
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=1;i<myPow(10, n);i++){
            a.add(i);
        }
        return a.stream().mapToInt(Integer::intValue).toArray();
    }
    public double myPow(double x, int n) {
        if(n<0){
            return 1/(myPow(x, -(n+1))*x);
        }
        Double base=1.0;
        Integer pow=n;
        Stack<Boolean> addDecision=new Stack<>();
        while(pow>0){
            if(pow%2==0){
                addDecision.add(false);
            }
            else{
                addDecision.add(true);
            }
            pow/=2;
        }
        while(!addDecision.empty()){
            base*=base;
            if(addDecision.pop()){
                base*=x;
            }
        }
        return base;
    }
}

public class Offer17 {
    
}
