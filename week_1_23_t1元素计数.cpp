#include "tool.h"
using namespace std;


class Solution {
public:
    int countElements(vector<int>& nums) {
        int max_num=nums[0];
        int min_num=nums[0];
        int max_count=0;
        int min_count=0;
        for(int i=0;i<nums.size();i++) {
            if(nums[i]==max_num){
                max_count++;
            }
            if(nums[i]==min_num){
                min_count++;
            }
            if(nums[i]>max_num){
                max_num=nums[i];
                max_count=1;
            }
            else if(nums[i]<min_num){
                min_num=nums[i];
                min_count=1;
            }
        }
        if(min_num==max_num){
            max_count=0;
        }
        return nums.size()-min_count-max_count;
    }
};

int main() {
    Solution solution;
    vector<int> nums={1,3,2,1,1};
    int result=solution.countElements(nums);
    printf("%d",result);
}
// 输入：nums = [11,7,2,15]
// 输出：2
// 解释：元素 7 ：严格较小元素是元素 2 ，严格较大元素是元素 11 。
// 元素 11 ：严格较小元素是元素 7 ，严格较大元素是元素 15 。
// 总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。