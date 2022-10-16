#include <stdio.h>
#include <stdlib.h>

//* Definition for singly-linked list.
struct ListNode {
	int val;
	struct ListNode *next;
};



struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
	struct ListNode* l1t=l1;
	struct ListNode* l2t=l2;
	struct ListNode* result=calloc(1,sizeof(struct ListNode));
	struct ListNode* returnVal=result;
	while(l1t||l2t){
		if(l1t&&l2t){
			result->val+=l1t->val+l2t->val;
			l1t=l1t->next;
			l2t=l2t->next;
		}
		else if(l1t){
			result->val+=l1t->val;
			l1t=l1t->next;
		}
		else if(l2t){
			result->val+=l2t->val;
			l2t=l2t->next;
		}
		if(result->val>=10){
			result->next=calloc(1,sizeof(struct ListNode));
			result->val-=10;
			result->next->val++;
			result=result->next;
		}
		else if(l1t||l2t){
			result->next=calloc(1,sizeof(struct ListNode));
			result=result->next;
		}
	}
	return returnVal;
}

int main() {
	struct ListNode l11,l12,l13,l14;
	struct ListNode l21,l22,l23,l24;
	l11.val=2;
	l11.next=&l12;
	l12.val=9;
	l12.next=&l13;
	l13.val=4;
	l13.next=NULL;
	l14.val=2;
	l14.next=NULL;
	l21.val=5;
	l21.next=&l22;
	l22.val=6;
	l22.next=&l23;
	l23.val=4;
	l23.next=&l24;
	l24.val=9;
	l24.next=NULL;
	addTwoNumbers(&l11,&l21);
}
