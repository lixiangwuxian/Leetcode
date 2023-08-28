package Offer11;

import java.util.Arrays;

class Solution {
    public int minArray(int[] numbers) {
        if(numbers.length==1){
            return numbers[0];
        }
        if(numbers.length==0){
            return 5000;
        }
        if(numbers[0]<numbers[numbers.length-1]){
            return numbers[0];
        }
        return min(minArray(Arrays.copyOfRange(numbers, 0, numbers.length/2)),minArray(Arrays.copyOfRange(numbers, numbers.length/2,numbers.length)));
    }
    int min(int a,int b){
        if(a>b){
            return b;
        }
        return a;
    }
}

public class Offer11 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // int[] numbers1 = {10,1,10,10,10};
        // System.out.println("Min element: " + solution.minArray(numbers1));

        // int[] numbers2 = {4, 5, 6, 7, 0, 1, 2};
        // System.out.println("Min element: " + solution.minArray(numbers2));

        // int[] numbers3 = {1};
        // System.out.println("Min element: " + solution.minArray(numbers3));

        // int[] numbers4 = {2, 2, 2, 0, 1};
        // System.out.println("Min element: " + solution.minArray(numbers4));

        int[] numbers5 = {2, 2, 2};
        System.out.println("Min element: " + solution.minArray(numbers5));
    }
}
