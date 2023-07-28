package Offer58;

class Solution {
    public String reverseWords(String s) {
        if(s.length()<1){
            return s;
        }
        StringBuffer r=new StringBuffer();
        int rpos=s.length()-1;
        int loffset=0;
        while(rpos>=0){
            loffset=0;
            while(loffset-1<rpos&&s.charAt(rpos-loffset)!=' '){
                loffset++;
            }
            if(loffset>0){
                r.append(s.substring(rpos-loffset+1, rpos+1)+" ");
            }
            if(loffset==0){
                rpos--;
            }
            else{
                rpos=rpos-loffset;
            }
        }
        if(r.length()>=1){
            r.deleteCharAt(r.length()-1);
        }
        return r.toString();
    }
}

public class Offer58 {
    public static void main(String[] args) {
        Solution s=new Solution();
        String r=s.reverseWords(" ");
        System.out.println(r);
    }
}
