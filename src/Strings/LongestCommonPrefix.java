package Strings;

import java.util.ArrayList;
import java.util.Collections;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] A) {
        StringBuffer str=new StringBuffer();
        if(A.length==0)
            return "";
        int j=0;
        int min=Integer.MAX_VALUE;
        int indx=0;
        for(int i=0;i<A.length;i++)
        {
            if(A[i].length()<min){
                min=A[i].length();
                indx=i;}
        }
        while(j<A[indx].length()){
            for(int i=0;i<A.length;i++){
                if(A[indx].charAt(j)!=A[i].charAt(j))
                    return str.toString();
            }
            str.append(A[indx].charAt(j));
            j++;
        }
        return str.toString();
    }
    public static String longestCommonPrefix2(String[] A) {
        ArrayList<String> arr=new ArrayList<>();
        for(int i=0;i<A.length;i++){
            arr.add(A[i]);
        }
        Collections.sort(arr);
        StringBuffer str=new StringBuffer();
        int min=Math.min(arr.get(0).length(),arr.get(A.length-1).length());
        for(int i=0;i<min;i++){
            if(arr.get(0).charAt(i)!=arr.get(A.length-1).charAt(i))
                return str.toString();
            else
                str.append(arr.get(0).charAt(i));
        }
        return str.toString();
    }

    public static void main(String[] args) {
       String A[] = { "aaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
        System.out.println(longestCommonPrefix2(A));
    }
}
