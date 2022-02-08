#include "tool.h"
using namespace std;

class Solution {
public:
    string replaceSpace(string s) {
        string result;
        int i;
        for (i = 0; i < s.length(); i++) {
            if(s[i]!=' '){
                result.push_back(s[i]);
            }
            else{
                result.push_back('%');
                result.push_back('2');
                result.push_back('0');
            }
        }
        return result;
    }
};