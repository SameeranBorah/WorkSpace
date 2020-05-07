package Queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KLargest {
    public static void main(String[] args) {
        int arr[]={2,5,4,1,7,5,9,3,4};
        int n=3;
        System.out.println(findMax(arr,3));
    }

    public static int findMax(int[]arr,int n) {
        PriorityQueue<Integer> Q=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<n;i++)
            Q.add(arr[i]);
        for(int i=n;i<arr.length;i++){
            if(arr[i]>Q.peek()){
                Q.poll();
                Q.add(arr[i]);
            }
        }
        return Q.peek();
    }
}
