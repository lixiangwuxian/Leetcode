#include "tool.h"
using namespace std;

/**类型：动态规划
 * 
 * 
 */

class Solution {
public:
    int countVowelPermutation(int n) {
        long long int arrange[10]={};
        for (int i=0; i<5; i++){
            arrange[i*2]=1;
        }
        for (int i=0; i<n-1; i++){
            arrange[0+i%2]=(arrange[2+(i+1)%2]+arrange[4+(i+1)%2]+arrange[8+(i+1)%2])%1000000007;
            arrange[2+i%2]=(arrange[0+(i+1)%2]+arrange[4+(i+1)%2])%1000000007;
            arrange[4+i%2]=(arrange[2+(i+1)%2]+arrange[6+(i+1)%2])%1000000007;
            arrange[6+i%2]=arrange[4+(i+1)%2]%1000000007;
            arrange[8+i%2]=(arrange[4+(i+1)%2]+arrange[6+(i+1)%2])%1000000007;
        }
        if(n%2==1){
            return arrange[1]+arrange[3]+arrange[5]+arrange[7]+arrange[9];
        }
        return arrange[0]+arrange[2]+arrange[4]+arrange[6]+arrange[8];
    }
};

int main() {
    Solution solution;
    int num=5;
    int result=solution.countVowelPermutation(num);
    printf("%d",result);
}