package Strings;

import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class LargestNumber {
    static String max="";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        for(int i=0;i<N;i++){
            int S=sc.nextInt();
            String s=sc.next();
            max=s;
            findLargest(s,S);
            System.out.println(max);

        }


    }
    public static String swap(String s, int i,int j){
        char[] strArray = s.toCharArray();
        char temp = strArray[i];
        strArray[i] = strArray[j];
        strArray[j] = temp;
        return  String.valueOf(strArray);

    }
    public static void findLargest(String s, int S){
        if(S==0)
            return;
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)<s.charAt(j)){
                   s=swap(s,i,j);
                    if(s.compareTo(max)>0)
                        max=s;
                    findLargest(s,S-1);
                    s=swap(s,i,j);
                }

            }


        }

    }
}
