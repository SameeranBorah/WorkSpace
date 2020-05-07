package Stack;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class EqualStacks {

    /*
     * Complete the equalStacks function below.
    */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        /*
         * Write your code here.
         */
        Stack<Integer> S1=new Stack();
        Stack<Integer> S2=new Stack();
        Stack<Integer> S3=new Stack();
        int sum1=0,sum2=0,sum3=0;
        for(int i=h1.length-1;i>=0;i--){
            S1.push(h1[i]);
            sum1+=h1[i];
        }
        for(int i=h2.length-1;i>=0;i--){
            S2.push(h2[i]);
            sum2+=h2[i];
        }
        for(int i=h3.length-1;i>=0;i--){
            S3.push(h3[i]);
            sum3+=h3[i];
        }
        System.out.println(sum1);
//        Stack<Integer> S1=new Stack<>();
//        Stack<Integer> S2=new Stack<>();
//        Stack<Integer> S3=new Stack<>();
//        int sum1=0;
//        int sum2=0;
//        int sum3=0;
//        for(int i=h1.length-1;i>=0;i--){
//
//            S1.push(sum1);
//            sum1=sum1+h1[i];
//        }
//        for(int i=h2.length-1;i>=0;i--){
//
//            S2.push(sum2);
//            sum2=sum2+h2[i];
//        }
//        for(int i=h3.length-1;i>=0;i--){
//
//            S3.push(sum3);
//            sum3=sum3+h3[i];
//        }

//        if(S1.peek().equals(S2.peek())){
//            if(S2.peek().equals(S3.peek()))
//                return S1.peek();
//        }

        System.out.println(S1);
        System.out.println(S2);
        System.out.println(S3);
        System.out.println(sum1);
        while(!(sum1==sum2&&sum2==sum3&&sum3==sum1)){
            if(sum1==0||sum2==0||sum3==0){
                sum1=0;
                break;
            }else if(sum1>=sum2&&sum1>=sum3){
                sum1-=S1.peek();
                S1.pop();
            }else if(sum2>=sum1&&sum2>=sum3){
                sum2-=S2.peek();
                S2.pop();
            }else if(sum3>=sum1&&sum3>=sum2){
                sum3-=S3.peek();
                S3.pop();
            }
        }
        return sum1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        System.out.println(String.valueOf(result));

    }
}
