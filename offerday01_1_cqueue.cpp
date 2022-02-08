#include "tool.h"
using namespace std;

class CQueue {
    private:
        stack<int> a;
        stack<int> b;
    public:
        CQueue() {
        }
        
        void appendTail(int value) {
            a.push(value);
        }
        
        int deleteHead() {
            if(!b.empty()) {
                int result=b.top();
                b.pop();
                return result;
            }
            else {
                if(a.empty()){
                    return -1;
                }
                while(!a.empty()) {
                    b.push(a.top());
                    a.pop();
                }
                return deleteHead();
            }
        }
};

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue* obj = new CQueue();
 * obj->appendTail(value);
 * int param_2 = obj->deleteHead();
 */