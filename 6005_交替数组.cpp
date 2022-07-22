#include "tool.h"
using namespace std;

class Solution {
public:
    int minimumOperations(vector<int>& nums) {
        map<int,int> count_row1;
        map<int,int> count_row2;
        int r11_max=0, r21_max=0;
        int r12_max=0, r22_max=0;
        int r1_maxNum = 0,r2_maxNum = 0;
        for(int i=0; i<nums.size(); i+=2){
            count_row1[nums[i]]++;
            if(i+1<nums.size()){
                count_row2[nums[i+1]]++;
            }
        }
        for(int i=0; i<count_row1.size();i++){
            if(r11_max<count_row1[i]){
                r12_max=r11_max;
                r1_maxNum=i;
                r11_max=count_row1[i];
            }
        }
        for(int i=0; i<count_row2.size();i++){
            if(r21_max<count_row2[i]){
                r22_max=r21_max;
                r2_maxNum=i;
                r21_max=count_row2[i];
            }
        }
        if(r1_maxNum!=r2_maxNum){
            if(r12_max==0&&r22_max==0){
                return nums.size();
            }
            return nums.size()-r11_max-r21_max;
        }
        else if(r12_max!=0&&r22_max!=0){
            return nums.size()-max(r21_max+r12_max,r11_max+r22_max);
        }
        else if(r12_max==0&&r22_max!=0){
            return nums.size()-max(r21_max+r11_max,r11_max+r22_max);
        }
        else if(r12_max!=0&&r22_max==0){
            return nums.size()-max(r21_max+r12_max,r11_max+r22_max);
        }
        else if(r12_max==0&&r22_max==0){
            return nums.size()-r11_max-r21_max;
        }
    }
    return 0;
};

int main() {
    Solution solution;
    vector<int> nums={1,2,2,2,2};
    int result=solution.minimumOperations(nums);
    printf("%d",result);
}