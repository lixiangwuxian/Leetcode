#include "tool.h"
using namespace std;

class Solution {
public:
    vector<int> findLonely(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<int> result;
        for (int i = 1; i < nums.size()-1; i++){
            if((nums[i]-nums[i-1]>1)&&(nums[i+1]-nums[i]>1)){
                result.push_back(nums[i]);
            }
        }
        if(nums[1]-nums[0]>1){
            result.push_back(nums[0]);
        }
        if(nums[nums.size()-1]-nums[nums.size()-2]>1){
            result.push_back(nums[nums.size()-1]);
        }
        return result;
    }
};

int main() {
    Solution solution;
    vector<int> nums={1,3,5,3};
    vector<int> result=solution.findLonely(nums);
    printf("%d %d",result[0],result[1]);
}