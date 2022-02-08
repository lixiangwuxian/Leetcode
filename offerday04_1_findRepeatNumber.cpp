#include "tool.h"
using namespace std;

class Solution {
public:
    int findRepeatNumber(vector<int>& nums) {
        map<int,bool> num_map;
        for (int i = 0; i< nums.size(); i++){
            if(num_map[nums[i]]!= true){
                num_map[nums[i]] = true;
            }
            else if(num_map[nums[i]]==true){
                return nums[i];
            }
        }
        return -1;
    }
};