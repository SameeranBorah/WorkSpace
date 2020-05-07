package Stack;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String str[]={ "-2", "-1", "2", "+", "-1", "-", "-", "2", "-2", "1", "-", "+", "-", "-2", "-2", "-", "-1", "2", "-2", "-", "-2", "-1", "+", "1", "1", "-", "-1", "+", "1", "*", "*", "2", "+", "*", "-", "-2", "1", "-2", "*", "+", "-2", "*", "1", "*", "-", "*", "*"};
        System.out.println(evalRPN(str));

    }
    public static int evalRPN(String[] A) {
        Stack<String> S=new Stack<>();
        if(A.length==1)
            return Integer.parseInt(A[0]);
        S.push(A[0]);
        S.push(A[1]);
        for(int i=2;i<A.length;i++){

            if(A[i].charAt(0)=='+'){
                int x,y;
                x=Integer.parseInt(S.pop());
                y=Integer.parseInt(S.pop());
                S.push(String.valueOf(x+y));
            }
            else if(A[i].charAt(0)=='*'){
                int x,y;
                x=Integer.parseInt(S.pop());
                y=Integer.parseInt(S.pop());
                S.push(String.valueOf(x*y));
            }
            else if(A[i].charAt(0)=='-'){
                int x,y;
                x=Integer.parseInt(S.pop());
                y=Integer.parseInt(S.pop());
                S.push(String.valueOf(y-x));
            }
            else if(A[i].charAt(0)=='/'){
                int x,y;
                x=Integer.parseInt(S.pop());
                y=Integer.parseInt(S.pop());
                S.push(String.valueOf(y/x));


            }
            else {
                S.push(A[i]);

            }
        }

        return Integer.parseInt(S.pop());
    }
}
