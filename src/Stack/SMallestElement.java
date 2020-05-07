package Stack;


import java.sql.SQLOutput;
import java.util.Stack;

public class SMallestElement {
    public static int[] prevSmaller(int[] A) {
        int B[]=new int[A.length];
        Stack<Integer> S=new Stack<>();
        S.push(A[0]);
        B[0]=-1;
        for(int i=1;i<A.length;i++){

            if(S.peek()>A[i]){
                S.push(A[i]);
                B[i]=-1;
            }
            else
                B[i]=S.peek();
        }
        return B;
    }

    public static void main(String[] args) {
        int A[]={34, 35, 27, 42, 5, 28, 39, 20, 28};
        int B[]=prevSmaller(A);
        for(int i=0;i<B.length;i++){
            System.out.println(B[i]);
        }

    }
}
