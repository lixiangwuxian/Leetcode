package Offer27;
import TreeNode.TreeNode;

class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode tmp=root.left;
        root.left=mirrorTree(root.right);
        root.right=mirrorTree(tmp);
        return root;
    }
}

public class Offer27 {
    
}
