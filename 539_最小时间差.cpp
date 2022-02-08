#include"tool.h"
using namespace std;

class Solution {
public:
    int findMinDifference(vector<string>& timePoints) {
        vector<int> timePoints_int;
        // if(timePoints.size()==1){
        //     return 0;
        // }
        for(int i = 0; i < timePoints.size(); i++){
            timePoints_int.push_back(HHMM2int(timePoints[i]));
        }
        sort(timePoints_int.begin(), timePoints_int.end());
        int min_diff=timePoints_int[1]-timePoints_int[0];
        for(int i = 2; i < timePoints_int.size();i++){
            min_diff = min(min_diff,min(timePoints_int[i]-timePoints_int[i-1],1440-timePoints_int[i]+timePoints_int[i-1]));
        }
        min_diff = min(min_diff,min(timePoints_int[timePoints_int.size()-1]-timePoints_int[0],1440-timePoints_int[timePoints_int.size()-1]+timePoints_int[0]));
        return min_diff;
    }
    inline int HHMM2int(string timePoint){
        return (timePoint[0]-'0')*10*60+(timePoint[1]-'0')*60+(timePoint[3]-'0')*10+timePoint[4]-'0';
    }
};