package Offer59_i;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class Pair{
    public int val;
    public int pos;
    Pair(int v,int p){
        val=v;
        pos=p;
    }
}

class Solution {
    Deque<Pair> numsDeque=new ArrayDeque<>();
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> maxNums=new ArrayList<>();
        //init
        for(int i=0;i<k;i++){
            pushNum(nums[i],i);
        }
        maxNums.add(getMax(0));
        //insert max nums
        for(int i=k;i<nums.length;i++){
            pushNum(nums[i], i);
            maxNums.add(getMax(i-k+1));
        }
        return maxNums.stream().mapToInt(Integer::intValue).toArray();
    }
    void pushNum(int num,int pos){
        while(numsDeque.peek()!=null&&numsDeque.peekFirst().val<num){
            numsDeque.removeFirst();
        }
        numsDeque.addFirst(new Pair(num, pos));
    }
    /**
     * 
     * @param pos 区间起始位置
     * @return 最大值
     */
    int getMax(int pos){
        while(numsDeque.peek()!=null&&numsDeque.peekLast().pos<pos){
            numsDeque.pollLast();
        }
        return numsDeque.getLast().val;
    }
}

public class Offer59 {
    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int k=3;
        Solution s=new Solution();
        int[] result=s.maxSlidingWindow(nums, k);
        for(int i:result){
            System.out.println(i);
        }
    }
}
