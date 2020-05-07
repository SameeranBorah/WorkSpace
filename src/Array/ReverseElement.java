package Array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ReverseElement {

    // Complete the reverseArray function below.
    static int[] reverseArray(int[] a) {
        int i=0;
        int n=a.length-1;
        while(i<n){
            int k=a[i];
            a[i]=a[n];
            a[n]=k;
            i++;
            n--;
        }

        return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] res = reverseArray(arr);

        for (int i = 0; i < res.length; i++) {
            System.out.print(String.valueOf(res[i]));

            if (i != res.length - 1) {
                System.out.print(" ");
            }
        }



        scanner.close();
    }
}
