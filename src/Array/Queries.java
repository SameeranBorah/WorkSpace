package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Queries {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        List<Integer> arr= new ArrayList<>(N);
        for(int i=0;i<N;i++){
            arr.add(sc.nextInt());
        }
        List<List<Integer>> queries= new ArrayList<>(M);
        for(int i=0;i<M;i++){
            List<Integer> l=new ArrayList<>();
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            l.add(sc.nextInt());
            queries.add(l);
        }
        System.out.println(queries);
        for(int i=0;i<M;i++){
            if(queries.get(i).get(0)==1){
                int z=queries.get(i).get(2);
                int x=(queries.get(i).get(2))-queries.get(i).get(1);
                while(x>=0){
                    arr.add(0,arr.get(z-1));
                    //System.out.println(x);
                    arr.remove((queries.get(i).get(2))+0);
                    x--;
                }
            }
            else{
                int z=queries.get(i).get(1);
                int x=(queries.get(i).get(2))-queries.get(i).get(1);
                while(x>=0){
                    arr.add(N,arr.get(z-1));
                    arr.remove((z)-1);
                    x--;
                }

            }
        }
        System.out.println(arr);
        System.out.println(Math.abs(arr.get(0)-arr.get(N-1)));
        for(int i=0;i<N;i++){
            System.out.print(arr.get(i)+" ");
        }
    }
}

