package Array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KsumArray {
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
        Map<Integer,Integer> map=new HashMap<>();

        int max=0;
        int B[]=new int[A.length];
        for(int i=0;i<A.length;i++){
            //A[i]=A[i]-S;
            max=max+A[i];
            B[i]=max;
            map.put(B[i],i);
        }
        map.put(0,0);
        //System.out.println(map);
        if(map.containsKey(S)){
            System.out.println(1+" "+(map.get(S)+1));
            return;}
        for(int i=1;i<A.length;i++){

            if(map.containsKey(B[i-1]+S)){
                System.out.println(i+1+" "+(map.get(B[i-1]+S)+1));
                return;}
        }
        System.out.println(-1);

    }
}
