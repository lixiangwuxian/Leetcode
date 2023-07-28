package Offer52;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len_a=getLen(headA);
        int len_b=getLen(headB);
        ListNode ptrA=headA;
        ListNode ptrB=headB;
        if(len_a>len_b){
            for(int i=0;i<len_a-len_b;i++){
                ptrA=ptrA.next;
            }
        }
        else{
            for(int i=0;i<len_b-len_a;i++){
                ptrB=ptrB.next;
            }
        }
        while(ptrA!=null){
            if(ptrA==ptrB){
                return ptrA;
            }
            ptrA=ptrA.next;
            ptrB=ptrB.next;
        }
        return null;
    }
    int getLen(ListNode ln){
        int len=0;
        while(ln!=null){
            len++;
            ln=ln.next;
        }
        return len;
    }
}

public class Offer52 {
    public static void main(String[] args) {
        // 创建第一个链表: 1 -> 2 -> 3
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        // 创建第二个链表: 4 -> 5 -> 6
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(9);

        // 创建节点 7 和 8
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);

        // 连接节点 7 和 8 到链表 l1
        l1.next.next.next = node7;
        node7.next = node8;

        // 连接节点 7 和 8 到链表 l2
        l2.next.next.next.next = node7;
        Solution s = new Solution();
        ListNode result = s.getIntersectionNode(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
