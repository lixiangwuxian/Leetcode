package Offer21;

class Solution {
    public int[] exchange(int[] nums) {
        int p_odd=nums.length-1;
        int p_even=0;
        while(p_odd>p_even){
            if(nums[p_odd]%2==0){
                p_odd--;
                continue;
            }
            if(nums[p_even]%2==1){
                p_even++;
                continue;
            }
            int tmp=nums[p_odd];
            nums[p_odd]=nums[p_even];
            nums[p_even]=tmp;
        }
        return nums;
    }
}

public class Offer21 {
    
}
