package Offer53_i;

public class Offer53 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] a={1,2,3,4,5,6,7,8,8,8,8,8,9};
        System.out.println(s.search(a, 8));
    }
}
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return 0;
        }
        if(nums[nums.length-1]==target){
            return binSearch(nums, target+1)-binSearch(nums, target)+1;
        }
        return binSearch(nums, target+1)-binSearch(nums, target);
    }
    int binSearch(int[] nums,int target){
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return left;
    }
}