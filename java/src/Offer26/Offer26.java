package Offer26;
import TreeNode.TreeNode;
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null){
            return false;
        }
        return TestSubStruct(A, B)||isSubStructure(A.left, B)||isSubStructure(A.right, B);
    }
    boolean TestSubStruct(TreeNode A, TreeNode B){
        if(B==null){
            return true;
        }
        if(A==null){
            return false;
        }
        if(A.val!=B.val){
            return false;
        }
        return TestSubStruct(A.left, B.left)&&TestSubStruct(A.right, B.right);
    }
}

public class Offer26 {
    
}
