package Offer32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> nodeQueue=new LinkedList<>();
        ArrayList<Integer> result=new ArrayList<>();
        if(root!=null){
            nodeQueue.add(root);
            while(!nodeQueue.isEmpty()){
                TreeNode thisNode=nodeQueue.poll();
                result.add(thisNode.val);
                if(thisNode.left!=null){
                    nodeQueue.add(thisNode.left);
                }
                if(thisNode.right!=null){
                    nodeQueue.add(thisNode.right);
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

public class Offer32 {
    
}
