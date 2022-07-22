#include "tool.h"
using namespace std;

class Solution {
public:
    double knightProbability(int n, int k, int row, int column) {
        struct vecRC{
            int row;
            int column;
            int step;
        };
        queue<vecRC> vecRCQueue;
        vecRCQueue.push({row, column,1});
        double chanceOutside=0;
        while(vecRCQueue.front().step<=k){
            if(vecRCQueue.front().row-1>=0 && vecRCQueue.front().column-2>=0){
                vecRCQueue.push({vecRCQueue.front().row-1, vecRCQueue.front().column-2, vecRCQueue.front().step+1});
            }
            else{
                chanceOutside+=1.0/(8*vecRCQueue.front().step);
            }
            if(vecRCQueue.front().row-2>=0 && vecRCQueue.front().column-1>=0){
                vecRCQueue.push({vecRCQueue.front().row-2, vecRCQueue.front().column-1, vecRCQueue.front().step+1});
            }
            else{
                chanceOutside+=1.0/(8*vecRCQueue.front().step);
            }
            if(vecRCQueue.front().row+1<n && vecRCQueue.front().column-2>=0){
                vecRCQueue.push({vecRCQueue.front().row+1, vecRCQueue.front().column-2, vecRCQueue.front().step+1});
            }
            else{
                chanceOutside+=1.0/(8*vecRCQueue.front().step);
            }
            if(vecRCQueue.front().row-2>=0 && vecRCQueue.front().column+1<n){
                vecRCQueue.push({vecRCQueue.front().row-2, vecRCQueue.front().column+1, vecRCQueue.front().step+1});
            }
            else{
                chanceOutside+=1.0/(8*vecRCQueue.front().step);
            }
            if(vecRCQueue.front().row-1>=0&& vecRCQueue.front().column+2<n){
                vecRCQueue.push({vecRCQueue.front().row-1, vecRCQueue.front().column+2, vecRCQueue.front().step+1});
            }
            else{
                chanceOutside+=1.0/(8*vecRCQueue.front().step);
            }
            if(vecRCQueue.front().row+2<n && vecRCQueue.front().column-1<n){
                vecRCQueue.push({vecRCQueue.front().row+2, vecRCQueue.front().column-1, vecRCQueue.front().step+1});
            }
            else{
                chanceOutside+=1.0/(8*vecRCQueue.front().step);
            }
            if(vecRCQueue.front().row+1<n && vecRCQueue.front().column+2<n){
                vecRCQueue.push({vecRCQueue.front().row+1, vecRCQueue.front().column+2, vecRCQueue.front().step+1});
            }
            else{
                chanceOutside+=1.0/(8*vecRCQueue.front().step);
            }
            if(vecRCQueue.front().row+2<n && vecRCQueue.front().column+1<n){
                vecRCQueue.push({vecRCQueue.front().row+2, vecRCQueue.front().column+1, vecRCQueue.front().step+1});
            }
            else{
                chanceOutside+=1.0/(8*vecRCQueue.front().step);
            }
            vecRCQueue.pop();
        }
        return 1-chanceOutside;
    }
};