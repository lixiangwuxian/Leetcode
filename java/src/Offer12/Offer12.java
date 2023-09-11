package Offer12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Pos{
    int x;
    int y;
    char ch;
    boolean used=false;
    public Pos(int x,int y){
        this.x=x;
        this.y=y;
    }
    boolean isNeighbor(Pos p2){
        if(p2.x==x){
            if(p2.y-y==1||p2.y-y==-1){
                return true;
            }
        }
        if(p2.y==y){
            if(p2.x-x==1||p2.x-x==-1){
                return true;
            }
        }
        return false;
    }
}

class Solution {
    Map<Character,ArrayList<Pos>> all_chars;
    public boolean exist(char[][] board, String word) {
        int x=0;
        int y=0;
        all_chars=new HashMap<>();
        for(char[] col:board){
            for(char ch:col){
                ArrayList<Pos> thisChArr=all_chars.get(ch);
                if(thisChArr==null){
                    thisChArr=new ArrayList<>();
                    all_chars.put(ch, thisChArr);
                }
                thisChArr.add(new Pos(x,y));
                x++;
            }
            x=0;
            y++;
        } 
        return search(word, null);
    }
    boolean search(String word,Pos prev){
        if(word.equals("")){
            return true;
        }
        if(all_chars.get(word.toCharArray()[0])==null){
            return false;
        }
        for(Pos p:all_chars.get(word.toCharArray()[0])){
            if(prev==null){
                p.used=true;
                if(search(word.substring(1), p)){
                    return true;
                }
                p.used=false;
            }
            else{
                if(p.used==false&&p.isNeighbor(prev)){
                    p.used=true;
                    if(search(word.substring(1), p)){
                        return true;
                    }
                    p.used=false;
                }
            }
        }
        return false;
    }
}

public class Offer12 {
    public static void main(String[] args) {
        
    }
}
