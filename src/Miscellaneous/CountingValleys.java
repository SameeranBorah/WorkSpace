package Miscellaneous;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        Stack<Character> ch=new Stack<>();
        int count=0;
        for(int i=0;i<n;i++){
            if(ch.empty()) {
                if (s.charAt(i) == 'D') {
                    count++;
                }
                ch.push(s.charAt(i));
            }

            else {
                if(ch.peek()!=s.charAt(i))
                    ch.pop();
                else ch.push(s.charAt(i));

            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        System.out.println(countingValleys(n, s));



        scanner.close();
    }
}
