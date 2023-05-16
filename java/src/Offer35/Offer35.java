package Offer35;

import java.util.HashMap;
import java.util.Vector;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        Node nodeNow=head;
        var node_list=new Vector<Node>();
        var node_map=new HashMap<Node,Integer>();
        int count=0;
        while(nodeNow!=null){
            node_list.add(new Node(nodeNow.val));
            node_map.put(nodeNow,count);
            nodeNow=nodeNow.next;
            count++;
        }
        nodeNow=head;
        for(var n:node_list){
            if(node_map.get(nodeNow.random)!=null){
                n.random=node_list.elementAt(node_map.get(nodeNow.random));
            }
            nodeNow=nodeNow.next;
        }
        for(int i=0;i<node_list.size();i++){
            try{
                node_list.elementAt(i).next=node_list.elementAt(i+1);
            }
            catch(ArrayIndexOutOfBoundsException e){
                node_list.elementAt(i).next=null;
            }
        }
        if(node_list.size()==0){
            return null;
        }
        return node_list.elementAt(0);
    }
}

public class Offer35 {
    public static void main(String[] args) {

    }
}