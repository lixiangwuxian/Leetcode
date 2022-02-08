#include "tool.h"
using namespace std;

class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        queue<int>positiveNums;
        queue<int>negativeNums;
        vector<int> result;
        bool balance=true;
        for (int i = 0; i < nums.size(); i++){
            if (nums[i]>0){
                positiveNums.push(nums[i]);
            }
            else{
                negativeNums.push(nums[i]);
            }
        }
        while(!positiveNums.empty()||!negativeNums.empty()){
            if(balance){
                result.push_back(positiveNums.front());
                positiveNums.pop();
            }
            else{
                result.push_back(negativeNums.front());
                negativeNums.pop();
            }
            balance=!balance;
        }
        return result;
    }
};

// 给你一个下标从 0 开始的整数数组 nums ，数组长度为 偶数 ，由数目相等的正整数和负整数组成。

// 你需要 重排 nums 中的元素，使修改后的数组满足下述条件：

// 1.任意 连续 的两个整数 符号相反
// 2.对于符号相同的所有整数，保留 它们在 nums 中的 顺序 。
// 3.重排后数组以正整数开头。

// 重排元素满足上述条件后，返回修改后的数组。

// 提示：

//     2 <= nums.length <= 2 * 105
//     nums.length 是 偶数
//     1 <= |nums[i]| <= 105
//     nums 由 相等 数量的正整数和负整数组成
