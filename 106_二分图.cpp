#include "tool.h"
using namespace std;

enum color{
    not_spec=0,
    red=1,
    black=2
};

color reserve(color the_color){
    if(the_color==red){
        return black;
    }
    else if(the_color==black) {
        return red;
    }
    return not_spec;
}

class Solution {
private:
    vector<vector<int>> graph;
    vector<color> colored;
    vector<bool> checked;
    queue<int> render_queue;
public:
    bool isBipartite(vector<vector<int>>& graph) {//能否等分边，遍历每个点，对该点和相邻点染色
        this->graph=graph;
        for(auto src:graph){//init colors
            colored.push_back(not_spec);
            checked.push_back(false);
        }
        while(1){//图可能不是相连的，所以每个部分都要保证走过
            if(graph.size()>0){
                for (int i=0;i<checked.size();i++) {
                    if(checked.at(i)==false){
                        if(!check_and_render_dot(i)){
                            return false;
                        }
                        break;
                    }
                    if(i==checked.size()-1&&checked.at(i)==true){//所有点都走完了就可以保证一定可以二分
                        return true;
                    }
                }
            }
            else{
                return true;//map size=0
            }
            while(!render_queue.empty()){
                if(!check_and_render_dot(this->render_queue.front())){
                    return false;
                }
                this->render_queue.pop();
            }
        }
        return true;//只是以防万一
    }
    bool check_and_render_dot(int dot){
        if(checked.at(dot)==true){
            return true;
        }
        this->checked.at(dot)=true;
        if(this->colored.at(dot)==not_spec){
            this->colored.at(dot)=red;
        }
        //try render connected dots
        //
        for(int i=0;i<graph.at(dot).size();i++){
            int now_check_point=graph.at(dot).at(i);
            if(now_check_point==dot){
                return false;//self spined
            }
            if(colored.at(now_check_point)==not_spec){//good!
                colored.at(now_check_point)=reserve(this->colored.at(dot));
                if(checked.at(now_check_point)==false){
                    this->render_queue.push(now_check_point);
                }
            }
            else if(colored.at(now_check_point)==colored.at(dot)){//bad
                return false;
            }
        }
        return true;
    }
};

int main(){
    vector<vector<int>> graph;
    vector<int> nodes[10];
    nodes[1].push_back(2);
    nodes[1].push_back(4);
    nodes[1].push_back(6);
    nodes[2].push_back(1);
    nodes[2].push_back(4);
    nodes[2].push_back(8);
    nodes[2].push_back(9);
    nodes[3].push_back(7);
    nodes[3].push_back(8);
    nodes[4].push_back(1);
    nodes[4].push_back(2);
    nodes[4].push_back(8);
    nodes[4].push_back(9);
    nodes[5].push_back(6);
    nodes[5].push_back(9);
    nodes[6].push_back(1);
    nodes[6].push_back(5);
    nodes[6].push_back(7);
    nodes[6].push_back(8);
    nodes[6].push_back(9);
    nodes[7].push_back(3);
    nodes[7].push_back(6);
    nodes[7].push_back(9);
    nodes[8].push_back(2);
    nodes[8].push_back(3);
    nodes[8].push_back(4);
    nodes[8].push_back(6);
    nodes[8].push_back(9);
    nodes[9].push_back(2);
    nodes[9].push_back(4);
    nodes[9].push_back(5);
    nodes[9].push_back(6);
    nodes[9].push_back(7);
    nodes[9].push_back(8);
    for(auto node:nodes){
        graph.push_back(node);
    }
    Solution sol;
    if(sol.isBipartite(graph)){
        printf("True");
    }
    else {
        printf("False");
    }
    return 0;
}