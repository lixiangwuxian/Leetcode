class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* addHead=nullptr;
        ListNode* nowHead=nullptr;
        while (head != NULL) {
            addHead=new ListNode(head->val);
            addHead->next=nowHead;
            head=head->next;
            nowHead=addHead;
        }
        return nowHead;
    }
};