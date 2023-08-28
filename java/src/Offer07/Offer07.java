package Offer07;

import java.util.Arrays;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==1){
            return new TreeNode(preorder[0]);
        }
        if(preorder.length==0){
            return null;
        }
        int inRootIndex=serach(inorder,preorder[0]);
        int[] leftpre=Arrays.copyOfRange(preorder, 1, 1+inRootIndex);
        int[] rightpre=Arrays.copyOfRange(preorder,inRootIndex+1, inorder.length);
        int[] leftin=Arrays.copyOfRange(inorder, 0, inRootIndex);
        int[] rightin=Arrays.copyOfRange(inorder, inRootIndex+1, preorder.length);
        TreeNode root=new TreeNode(preorder[0]);
        root.left=buildTree(leftpre, leftin);
        root.right=buildTree(rightpre, rightin);
        return root;
        
    }
    public int serach(int[] nums,int target){
        int count=0;
        for(int i:nums){
            if(i==target){
                return count;
            }
            count++;
        }
        return -1;
    }
}

class Offer07{
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] pre={3,9,20,15,7};
        int[] in={9,3,15,20,7};
        s.buildTree(pre, in);
    }
}