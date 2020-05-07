package Array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        System.out.println(q.length);
        int n=q.length;
        int c=0;
        int s=0;
        for(int i=0;i<n-1; i++){

            c=0;

            for(int j=i+1; j<n;j++){
                s=c+s;
                if(q[i]>q[j]){
                    int k=q[i];
                    q[i]=q[j];
                    q[j]=k;
                    c++;
                    if(c>2){
                        System.out.println("Too chaotic");
                        return;
                    }
                }
            }
        }

        System.out.println(s);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
