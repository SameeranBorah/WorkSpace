package BackTracking;

import java.util.ArrayList;

public class Permutation {
    static ArrayList<String> result=new ArrayList<>();
    public static void main(String[] args) {
        String str="abcd";
      //  permute("",str);
        permute2(str,0,str.length());
        //System.out.println(result);
    }

    public static void permute(String prem,String word) {
        if(word.isEmpty()){
            result.add(prem+word);
            return;
        }
        for (int i = 0; i<word.length(); i++) {
            permute(prem + word.charAt(i), word.substring(0, i)
                    + word.substring(i + 1, word.length()));
        }



    }
    private static void permute2(String str, int start,int end){
        if(start==end){
            System.out.println(str);
            return;
        }
        for(int i=start;i<end;i++){
            str=swap(str, start,i);
            permute2(str, start+1,end);
            str=swap(str,start,i);
        }
    }
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
