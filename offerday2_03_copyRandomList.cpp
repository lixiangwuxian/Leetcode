#include "tool.h"

// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
class Solution {
public:
    Node* copyRandomList(Node* head) {
        Node* sourceNode = head;
        if(head== NULL)
            return NULL;
        Node* newNode=new Node(head->val);
        Node* thisNode=newNode;
        while (head->next !=NULL){
            thisNode->next=new Node(head->next->val);
            head=head->next;
            thisNode=thisNode->next;
        }
        head=sourceNode;
        thisNode=newNode;
        while (head !=NULL){
            if(head->random==NULL){
                thisNode->random=NULL;
            }
            else{
                thisNode->random=newNode;
                Node* MatchNode=sourceNode;
                while(MatchNode!=head->random){
                    MatchNode=MatchNode->next;
                    thisNode->random=thisNode->random->next;
                }
            }
            head=head->next;
            thisNode=thisNode->next;
        }
        return newNode;
    }
};