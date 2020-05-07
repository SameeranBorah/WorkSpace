package Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class MaxHistogramArea {
    public static int largestRectangleArea(int[] A) {
        Stack<Integer> S=new Stack<>();
        int maxArea=0;
        int area=0;
        int i;
        for(i=0;i<A.length;){
            if(S.isEmpty() || A[S.peek()]<=A[i]){
                S.push(i++);
            }
            else{
                int top=S.pop();
                if(S.isEmpty())
                    area=A[top]*i;
                else
                    area=A[top]*(i-S.peek()-1);
                if(area>maxArea)
                    maxArea=area;
            }

        }
        while(!S.isEmpty()){
            int top=S.pop();
            if(S.isEmpty())
                area=A[top]*i;
            else
                area=A[top]*(i-S.peek()-1);
            if(area>maxArea)
                maxArea=area;
        }
        return maxArea;

    }

    public static void main(String[] args) {
        int A[] = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(A));
    }
}
