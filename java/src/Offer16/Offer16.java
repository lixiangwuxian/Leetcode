package Offer16;

import java.util.Stack;

class Solution {
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

public class Offer16 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // 调用 myPow 函数计算幂
        double result = solution.myPow(1, -2147483648);
        
        // 打印结果
        System.out.println("Result: " + result);
    }
}
