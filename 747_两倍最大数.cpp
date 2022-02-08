#include "tool.h"
using namespace std;

class Solution {
public:
    int dominantIndex(vector<int>& nums) {
        int max = 0;
        int max_2nd =0;
        for(int i=0; i<nums.size(); i++){
            if(nums[max]<nums[i]){
                max_2nd=max;
                max=i;
            }
            else if(nums[max_2nd]<nums[i]||(nums[max]>nums[i]&&max==max_2nd)){
                max_2nd=i;
            }
        }
        if(nums[max_2nd]*2<=nums[max]||max_2nd==max){
            return max;
        }
        return -1;
    }
};

int main() {
    Solution solution;
    vector<int> nums={1};
    int result=solution.dominantIndex(nums);
    printf("%d",result);
}