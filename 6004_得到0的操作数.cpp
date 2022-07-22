#include "tool.h"

class Solution {
public:
    int countOperations(int num1, int num2) {
        int a=num1, b=num2;
        int count = 0;
        while(a!=0 && b!=0){
            if(a>b) a-=b;
            else b-=a;
            count++;
        }
        return count;
    }
};