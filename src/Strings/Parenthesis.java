package Strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Parenthesis {
    static String isBalanced(String s) {
        char[] ch=s.toCharArray();
        Stack<String> stack=new Stack<>();
        if(ch[0]==')'||ch[0]==']'||ch[0]=='}'){
            return "NO";
        }
        for(int i=0;i<ch.length;i++){
            if(stack.size()==0){
                stack.push(String.valueOf(ch[i]));
                //System.out.println(String.valueOf(ch[i]));
            }
            else if(stack.peek().equals("(")&&String.valueOf(ch[i]).equals(")")){
                stack.pop();
            }

            else if(stack.peek().equals("{")&&String.valueOf(ch[i]).equals("}")){
                stack.pop();
            }
            else if(stack.peek().equals("[")&&String.valueOf(ch[i]).equals("]")){
                stack.pop();
            }
            else
                stack.push(String.valueOf(ch[i]));

        }
        if(stack.size()==0)
            return "YES";
        else
            return "NO";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            System.out.println(result);
        }


        scanner.close();
    }
}
