package Offer05;

class Solution {
    public String replaceSpace(String s) {
        StringBuffer result=new StringBuffer();
        for(Character i:s.toCharArray()){
            if(i.equals(' ')){
                result.append("%20");
                continue;
            }
            result.append(i);
        }
        return result.toString();
    }
}

public class Offer05 {
    
}
