package Offer37;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class ValPair{
    int val;
    String parsedStr;
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer serializedTree=new StringBuffer();
        if(root==null){
            return "";
        }
        serializedTree.append(root.val);
        serializedTree.append('/');
        String leftStr,rightStr;
        if(root.left!=null){
            leftStr=serialize(root.left);
        }
        else{
            leftStr=new String();
        }
        if(root.right!=null){
            rightStr=serialize(root.right);
        }
        else{
            rightStr=new String();
        }
        serializedTree.append(leftStr.length());
        serializedTree.append('/');
        serializedTree.append(leftStr);
        serializedTree.append(rightStr);
        return serializedTree.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0){
            return null;
        }
        ValPair thisNode=parseVal(data);
        ValPair leftNodes=parseVal(thisNode.parsedStr);
        TreeNode result=new TreeNode(thisNode.val);
        result.left=deserialize(leftNodes.parsedStr.substring(0,leftNodes.val));
        result.right=deserialize(leftNodes.parsedStr.substring(leftNodes.val,leftNodes.parsedStr.length()));
        return result;
    }
    public ValPair parseVal(String data){
        ValPair result=new ValPair();
        boolean neg=false;
        for(int i=0;i<data.length();i++){
            if(data.charAt(i)<='9'&&data.charAt(i)>='0'){
                result.val*=10;
                result.val+=data.charAt(i)-'0';
            }
            else if(data.charAt(i)=='-'){
                neg=true;
            }
            else{
                result.parsedStr=data.substring(i+1);
                break;
            }
        }
        if(neg){
            result.val=-result.val;
        }
        return result;
    }
}

class Test {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Codec c=new Codec();
        System.out.println(c.serialize(root));
        root=c.deserialize(c.serialize(root));
    }
}
