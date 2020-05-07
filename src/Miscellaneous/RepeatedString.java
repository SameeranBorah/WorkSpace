package Miscellaneous;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long l=s.length();
        long k=n/l;
        long r=n%l;
        long count=0;
        long count1=0;
        char ch[]=s.toCharArray();
        for(int t=0;t<ch.length;t++){
            if(ch[t]=='a')
                count1++;
        }
        for(int t=0;t<r;t++){
            if(ch[t]=='a')
                count++;
        }
        return k*count1+count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println(result);
        scanner.close();
    }
}
