package Offer28;

import TreeNode.TreeNode;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return testSym(root.left, root.right);
    }
    boolean testSym(TreeNode left,TreeNode right){
        if(left==null||right==null){
            if(left==right){
                return true;
            }
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return testSym(left.left, right.right)&&testSym(left.right, right.left);
    }
}

public class Offer28 {
    
}
