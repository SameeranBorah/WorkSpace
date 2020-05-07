package Array;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SumArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int N=sc.nextInt();
            int S=sc.nextInt();
            int[] A=new int[N];

            for( int j=0;j<N;j++){
                A[j]=sc.nextInt();

            }
            sumArray(A,S);


        }
    }
    public static void sumArray(int A[], int S){

        int sum=A[0];
        int j=0;
        for(int i=1;i<=A.length;i++){
            while(sum>S &&j<i-1){
                sum=sum-A[j];
                j++;
            }
            if(sum==S){
                System.out.println((j+1)+" "+(i));
                return;
            }
            if(i<A.length)
            sum=sum+A[i];
        }
        System.out.println(-1);
    }
}
