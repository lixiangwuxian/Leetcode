package Offer29;

import java.util.ArrayList;

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        ArrayList<Integer> result=new ArrayList<>();
        int height=matrix.length;
        if(height==0){
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
        int width=matrix[0].length;
        for(int i=0;i<=min(height,width)/2;i++){
            for(int lt_rt=i;lt_rt<width-i-1;lt_rt++){
                result.add(matrix[i][lt_rt]);
            }
            for(int rt_rb=i;rt_rb<=height-i-1;rt_rb++){
                result.add(matrix[rt_rb][width-i-1]);
            }
            if(height-2*i>1){
                for(int rb_lb=width-i-2;rb_lb>=i;rb_lb--){
                    result.add(matrix[height-i-1][rb_lb]);
                }
            }
            if(width-2*i>1){
                for(int lb_lt=height-i-2;lb_lt>i;lb_lt--){
                    result.add(matrix[lb_lt][i]);
                }
            }
            if(result.size()==width*height){
                return result.stream().mapToInt(Integer::intValue).toArray();
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    int min(int a,int b){
        return a<b?a:b;
    }
}

public class Offer29 {
    public static void main(String[] args){
        Solution s=new Solution();
        int [][] a={{1,2},{5,6},{9,10}};
        int [] b=s.spiralOrder(a);
        for(int i:b){
            System.out.println(i);
        }
    }
}
