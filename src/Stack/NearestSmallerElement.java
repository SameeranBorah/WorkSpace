package Stack;


import java.util.Stack;

public class NearestSmallerElement {
    public static int[] prevSmaller(int[] A) {
        int B[]=new int[A.length];
        Stack<Integer> S=new Stack<>();

        for(int i=0;i<A.length;i++){
            while (!S.empty() && S.peek() >= A[i]) {
                S.pop();
            }
            if (S.empty()) {
                B[i]=-1;
            } else //Else print the nearest smaller element
            {
                B[i]=S.peek();
            }

            // Push this element
            S.push(A[i]);
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
