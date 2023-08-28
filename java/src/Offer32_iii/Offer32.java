package Offer32_iii;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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
        boolean sw=false;
        if(root!=null){
            nodeQueue.add(root);
            nodeQueue.add(null);
            Deque<Integer> row=new ArrayDeque<>();
            while(!nodeQueue.isEmpty()){
                TreeNode thisNode=nodeQueue.poll();
                if(thisNode==null){
                    result.add(new ArrayList<>(row));
                    if(nodeQueue.isEmpty()){
                        return result;
                    }
                    sw=!sw;
                    nodeQueue.add(null);
                    row.clear();
                    continue;
                }
                if(sw){
                    row.addFirst(thisNode.val);
                }
                else{
                    row.addLast(thisNode.val);
                }
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
    
}
