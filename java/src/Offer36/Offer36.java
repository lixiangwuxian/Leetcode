package Offer36;
import Node.Node;


class Solution {
    Node head=null;
    Node tail=head;
    public Node treeToDoublyList(Node root) {
        if(root==null){
            return root;
        }
        treeFlat(root);
        head.left=tail;
        tail.right=head;
        return head;
    }
    void treeFlat(Node root){
        Node left=root.left;
        Node right=root.right;
        if(left!=null){
            treeFlat(left);
        }
        if(head==null){
            head=root;
            tail=root;
        }
        tail.right=root;
        root.left=tail;
        tail=tail.right;
        tail.right=null;
        if(right!=null){
            treeFlat(right);
        }
    }
}

public class Offer36 {
    public static void main(String[] args) {
        // 创建一个简单的二叉搜索树
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        Solution solution = new Solution();
        Node result = solution.treeToDoublyList(root);

        // 打印双向链表的节点值
        Node current = result;
    }
}
