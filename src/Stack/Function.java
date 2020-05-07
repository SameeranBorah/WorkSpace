package Stack;

import java.util.Stack;

public class Function {
    Stack<Integer> S=new Stack<>();
    public void push(int x) {
        S.push(x);

    }

    public void pop() {
        if(S.size()!=0)
            S.pop();

    }

    public int top() {
        if(S.size()!=0)
            return -1;
        return S.peek();

    }

    public int getMin() {
        if(S.size()==0)
            return -1;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<S.size();i++)
        {
            if(S.get(i)<min)
                min=S.get(i);
        }
        return min;
    }

    public static void main(String[] args) {
        Function F=new Function();
        F.push(22);
        F.top();
        F.getMin();
    }
}
