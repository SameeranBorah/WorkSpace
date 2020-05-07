package Miscellaneous;

import java.io.*;
import java.util.*;


public class SockSolution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < n; i++) {
            int key = ar[i];
            if (map.containsKey(key)) {
                int value = map.get(key);
                map.put(key, value + 1);
            } else {
                map.put(key, 1);
            }
        }
        int count=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            map.put(entry.getKey(),entry.getValue()/2);
            count=count+map.get(entry.getKey());
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        System.out.println(sockMerchant(n, ar));



        scanner.close();
    }
}
