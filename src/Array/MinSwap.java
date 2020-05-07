package Array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinSwap {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int x=0;
        int count=0;
        int l = arr.length;
        for(int i=0;i<l-1;i++){
            for(int k=i+1;k<l;k++){
                if(arr[i]>arr[k]) {
                    x = arr[i];
                    arr[i] = arr[k];
                    arr[k] = x;
                    count++;
                }
            }
        }
        return count/l;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);
        System.out.println(res);

        scanner.close();
    }
}
