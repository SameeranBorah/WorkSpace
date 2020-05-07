package Array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int m, int[][] queries) {
        long arr[]=new long[n+1];
        long prefixSum[]=new long[n+1];
        long max=-9999;
        for(int i=0;i<m;i++)
        {
            int f=queries[i][0];
            int l=queries[i][1];
            int val=queries[i][2];
            arr[f-1]=arr[f-1]+val;
            arr[l]=arr[l]-val;
        }

        prefixSum[0] = arr[0];

        // Adding present element
        // with previous element
        for( int i = 1; i < arr.length; ++i ) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
            if (prefixSum[i] > max)
                max = prefixSum[i];
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, m,queries);
        System.out.println(result);

        scanner.close();
    }
}

