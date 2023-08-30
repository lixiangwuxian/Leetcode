package Offer51;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    int count=0;
    public int reversePairs(int[] nums) {
        mergesort(nums);
        return count;
    }
    int[] mergesort(int[] nums){
        if(nums.length<=1){
            return nums;
        }
        int mid=nums.length/2;
        int[] left=mergesort(Arrays.copyOfRange(nums, 0, mid));
        int[] right=mergesort(Arrays.copyOfRange(nums, mid, nums.length));
        return mergeArrays(left, right);
    }
    int[] mergeArrays(int[] n1,int[] n2){
        ArrayList<Integer> merged=new ArrayList<>();
        int countn2=0;
        for(int i=0;i<n1.length;i++){
            while(countn2<n2.length&&n2[countn2]<n1[i]){
                merged.add(n2[countn2]);
                countn2++;
                count+=n1.length-i;
            }
            merged.add(n1[i]);
        }
        while(countn2<n2.length){
            merged.add(n2[countn2]);
            countn2++;
        }
        return merged.stream().mapToInt(Integer::intValue).toArray();
    }
}

public class Offer51 {
    public static void main(String[] args) {
        Solution s=new Solution();
        int[] i={1,3,2,3,1};
        System.out.println(s.reversePairs(i));
    }
}
