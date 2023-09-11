package Offer41;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.LinkedList;

class MedianFinder {
    ArrayList<Integer> nums;
    public MedianFinder() {
        nums=new ArrayList<>();
    }
    
    public void addNum(int num) {
        int pos=searchPos(nums, num);
        nums.add(pos,num);
    }
    
    public double findMedian() {
        if(nums.size()==0){
            return 0.0;
        }
        if(nums.size()%2!=0){
            return nums.get(nums.size()/2);
        }
        return ((double)nums.get(nums.size()/2-1)+nums.get(nums.size()/2))/2;
    }
    int searchPos(ArrayList<Integer> n,int target){
        int left=0;
        int right=n.size()-1;
        if(right==-1){
            return 0;
        }
        if(right==0){
            return n.get(0)>target?0:1;
        }
        while(left<right){
            int mid=(left+right)/2;
            if(n.get(mid)<target){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        if(n.get(left)<target){
            left++;
        }
        return left;
    }
}

public class Offer41 {
    public static void main(String[] args) {
        // 创建 MedianFinder 对象
        MedianFinder medianFinder = new MedianFinder();

        // 添加数字
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);

        // 计算中位数并打印
        double median = medianFinder.findMedian();
        System.out.println("Median: " + median);
    }
}
