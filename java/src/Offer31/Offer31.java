package Offer31;

import java.util.ArrayDeque;
import java.util.Deque;



class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length!=popped.length){
            return false;
        }
        int countPush=0;
        int countPop=0;
        Deque<Integer> stack=new ArrayDeque<>();
        while(countPush<popped.length){
            stack.addFirst(pushed[countPush]);
            countPush++;
            while(stack.peek()!=null&&stack.peekFirst()==popped[countPop]){
                countPop++;
                stack.removeFirst();
            }
        }
        if(countPop!=popped.length){
            return false;
        }
        return true;
    }
}

public class Offer31 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] a={1,2,3},b={1,2,3};
        s.validateStackSequences(a,b);
    }
}