package j2605;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int ptr1=0,ptr2=0;
        while(ptr1<nums1.length&&ptr2<nums2.length){
            if(nums1[ptr1]>nums2[ptr2]){
                ptr2++;
            }
            else if(nums1[ptr1]<nums2[ptr2]){
                ptr1++;
            }
            else{
                return nums1[ptr1];
            }
        }
        if(nums1[0]>nums2[0]){
            return nums2[0]*10+nums1[0];
        }
        return nums1[0]*10+nums2[0];
    }
}

public class writeup {
    
}
