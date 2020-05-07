package Queue;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxSlidingWindow {
    public static void main(String[] args) {
        int A[]={648, 614, 490, 138, 657, 544, 745, 582, 738, 229, 775, 665, 876, 448, 4, 81, 807, 578, 712, 951, 867, 328, 308, 440, 542, 178, 637, 446, 882, 760, 354, 523, 935, 277, 158, 698, 536, 165, 892, 327, 574, 516, 36, 705, 900, 482, 558, 937, 207, 368};
        int b=3;
        int B[]=slidingMaximum(A,b);
        for(int i=0;i<B.length;i++){
            System.out.print(B[i]+" ");
        }

    }
    public static int findMax(Queue<Integer> Q){
        Integer max=0;
        for(int value :Q){

            if(value>max){
                max=value;
            }
        }
        return max;
    }
    public static int max1(int[] A){
        int max=0;
        for (int value : A) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static int[] slidingMaximum(final int[] A, int B) {
        int S[]=new int[A.length-B+1];
        Queue<Integer> Q = new ArrayDeque<>();
        if(B>A.length) {

            System.out.println(max1(A));
        }
        else{
            for(int i=0;i<B;i++){
                Q.add(A[i]);

            }
           // System.out.println(Q);
            S[0]=findMax(Q);
            int temp=Q.remove();
//            System.out.println(Q);
//            Q.poll();
//            System.out.println(Q);

            for(int i=B;i<A.length;i++) {
                if (temp == S[i - B]) {
                    Q.add(A[i]);
                    S[i - B + 1] = findMax(Q);
                    temp = Q.remove();
                } else {
                    int max;
                    Q.add(A[i]);
                    if (A[i] > S[i - B]) {

                        max = A[i];

                    } else
                        max = S[i - B];
                    temp = Q.remove();
                    S[i - B + 1] = max;
                }
            }

            //System.out.println(Q);

        }
        return S;

    }
}
