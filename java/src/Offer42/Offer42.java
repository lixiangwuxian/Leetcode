package Offer42;

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int pre=0;
        int maxVal=nums[0];
        for(int i:nums){
            pre=Math.max(pre, pre+i);
            maxVal=Math.max(maxVal,pre);
        }
        return maxVal;
    }
}

public class Offer42 {
    
}
