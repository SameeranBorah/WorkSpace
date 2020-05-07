package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Operations {
    public static void main(String[] args) {
        Stack<Integer> S=new Stack<>();
        Stack<Integer> max=new Stack<>();

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int j=sc.nextInt();
            if(j==1){
                int q=sc.nextInt();
                S.push(q);
                if(max.size()==0)
                    max.push(q);
                else
                    if(max.peek()<q)
                        max.push(q);

            }
            if(j==2){
                if(!max.empty()){
                    if(max.peek().equals(S.peek()))
                        max.pop();

                }
                S.pop();}
            if(j==3){

                System.out.println(max.peek());
            }
        }
    }
}
