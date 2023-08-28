package Offer32_ii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> nodeQueue=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        if(root!=null){
            nodeQueue.add(root);
            nodeQueue.add(null);
            ArrayList<Integer> row=new ArrayList<>();
            // result.add(new ArrayList<>());
            while(!nodeQueue.isEmpty()){
                TreeNode thisNode=nodeQueue.poll();
                // result.add(thisNode.val);
                if(thisNode==null){
                    if(nodeQueue.isEmpty()){
                        return result;
                    }
                    // result.add(new ArrayList<>());
                    result.add(row);
                    nodeQueue.add(null);
                    row=new ArrayList<>();
                    continue;
                }
                row.add(thisNode.val);
                if(thisNode.left!=null){
                    nodeQueue.add(thisNode.left);
                }
                if(thisNode.right!=null){
                    nodeQueue.add(thisNode.right);
                }
            }
        }
        return result;
    }
}

public class Offer32 {
    public static void main(String[] args) {
        Solution s=new Solution();
        TreeNode root = new TreeNode(1);
        
        root.left = new TreeNode(9);
        root.right = new TreeNode(3);
        
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);
        
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        s.levelOrder(root);
    }
}
