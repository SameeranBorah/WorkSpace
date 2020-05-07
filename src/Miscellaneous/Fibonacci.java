package Miscellaneous;

import java.util.*;

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fb = new Fibonacci();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int numbers[] = new int[10];
        for (int j = 0; j < n; j++){
            int m = sc.nextInt();
            numbers[j]=m;

        }

        for (int i = 0; i < n; i++){
            System.out.println(fb.fibR(numbers[i]));
        }

    }
    int fibR(int N){
        int a=0;
        int b=1;
        int c;

        if(N==0)
            return a;
        for(int i=2; i<=N; i++){
            c=a+b;
            a=b;
            b=c;
        }
        return b;
    }

}