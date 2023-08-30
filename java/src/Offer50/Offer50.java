package Offer50;

import java.util.HashMap;
import java.util.Map;

class LinkNode{
    Character ch;
    LinkNode next;
    Boolean unique=true;
    public LinkNode(char ch){
        this.ch=ch;
    }
}

class Solution {
    public char firstUniqChar(String s) {
        Map<Character,LinkNode> cmap=new HashMap<>();
        LinkNode head=null;
        LinkNode tail=null;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(head==null){
                head=new LinkNode(ch);
                tail=head;
                cmap.put(ch, head);
                continue;
            }
            LinkNode search_char=cmap.get(ch);
            if(search_char==null){
                search_char=new LinkNode(ch);
                tail.next=search_char;
                tail=tail.next;
                cmap.put(ch, search_char);
            }
            else{
                search_char.unique=false;
            }
        }
        while(head!=null){
            if(head.unique){
                return head.ch;
            }
            head=head.next;
        }
        return ' ';
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "loveleetcode";
        char result = solution.firstUniqChar(input);
        System.out.println("First unique character: " + result);
    }
}

public class Offer50 {
    
}
