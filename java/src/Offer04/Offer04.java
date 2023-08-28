package Offer04;

class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        if(matrix[0].length==0){
            return false;
        }
        int checkPoint=binSearch(matrix[0], target);
        int lineCount=0;
        while(lineCount<matrix.length){
            if(checkPoint==0&&matrix[lineCount][checkPoint]>target){
                return false;
            }
            if(matrix[lineCount][checkPoint]==target||checkPoint<matrix[0].length-1&&matrix[lineCount][checkPoint+1]==target){
                return true;
            }
            if(lineCount==matrix.length-1){
                return false;
            }
            checkPoint=getNewPos(matrix[lineCount+1], target, checkPoint);
            lineCount++;
        }
        return false;
    }
    int getNewPos(int[] line,int target,int nowPos){
        while(line[nowPos]>target&&nowPos>0){
            nowPos--;
        }
        return nowPos;
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

public class Offer04 {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1}
        };
        Solution s=new Solution();
        s.findNumberIn2DArray(matrix, 2);
    }
}
