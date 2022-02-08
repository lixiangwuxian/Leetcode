#include "tool.h"
using namespace std;

class Solution {
public:
    string reverseLeftWords(string s, int n) {
        string result;
        for (int i = 0; i < s.size(); i++){
            result.push_back(s[(i+n)%s.size()]);
        }
        result.push_back('\0');
        return result;
    }
};