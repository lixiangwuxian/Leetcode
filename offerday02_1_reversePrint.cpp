#include "tool.h"
using namespace std;
 struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    vector<int> reversePrint(ListNode* head) {
        ListNode* addHead=nullptr;
        ListNode* nowHead=nullptr;
        vector<int> result;
        while (head != NULL) {
            addHead=new ListNode(head->val);
            addHead->next=nowHead;
            head=head->next;
            nowHead=addHead;
        }
        while (nowHead != NULL) {
            result.push_back(nowHead->val);
            nowHead=nowHead->next;
        }
        return result;
    }
};