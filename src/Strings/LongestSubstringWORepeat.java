package Strings;

import java.util.*;

public class LongestSubstringWORepeat {
    public static int lengthOfLongestSubstring(String A) {
        if(A.length()==1)
            return 1;
        int max=0;
        HashSet<Character> hash=new HashSet<>();
        int j=0;
        for(int i=0;i<A.length();i++){
            if(!hash.add(A.charAt(i))){
                while(A.charAt(j)!=A.charAt(i)){
                    hash.remove(A.charAt(j++));
                }
                j++;
            }
            if(hash.size()>max)
                max=hash.size();
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcaa"));
    }
}
