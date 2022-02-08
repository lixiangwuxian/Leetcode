#include "tool.h"
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> tmp=nums;
        vector<int> result;
        sort(tmp.begin(),tmp.end());
        int i=0;
        int j=tmp.size()-1;
        for (; i<j; ) {
            if(tmp[i]+tmp[j]>target){
                j--;
            }
            else if(tmp[i]+tmp[j]<target){
                i++;
            }
            else{
                break;
            }
        }
        for (int k = 0; k < nums.size(); k++)
        {
            if(nums[k]==tmp[i]){
                result.push_back(k);
                continue;
            }
            if(nums[k]==tmp[j]){
                result.push_back(k);
                continue;
            }
        }
        return result;
    }
};

int main() {
    Solution solution;
    vector<int> nums={1,9,3,4,5,5,10,8};
    vector<int> result=solution.twoSum(nums,10);
    printf("%d %d",result[0],result[1]);
}