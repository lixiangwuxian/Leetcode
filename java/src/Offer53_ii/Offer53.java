package Offer53_ii;

class Solution {
    public int missingNumber(int[] nums) {
        int l=0,r=nums.length-1;
        while(l!=r){
            int mid=(l+r)/2;
            if(mid==nums[mid]){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        if(l==nums.length-1&&nums[l]==nums.length-1){
            return l+1;
        }
        return l;
    }
}

public class Offer53 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] a={0,1,2,3,4,5,6,8};
        System.out.println(s.missingNumber(a));
    }
}