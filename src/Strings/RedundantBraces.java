package Strings;

import com.sun.xml.internal.txw2.output.CharacterEscapeHandler;

import java.util.Stack;

public class RedundantBraces {
    public static int braces(String s) {
        Stack<Character> st = new Stack<>();
        char[] str = s.toCharArray();
        // Iterate through the given expression
        for (char ch : str) {

            // if current character is close parenthesis ')'
            if (ch == ')') {
                char top = st.peek();
                st.pop();

                // If immediate pop have open parenthesis '('
                // duplicate brackets found
                boolean flag = true;

                while (top != '(') {

                    // Check for operators in expression
                    if (top == '+' || top == '-'
                            || top == '*' || top == '/') {
                        flag = false;
                    }

                    // Fetch top element of stack
                    top = st.peek();
                    st.pop();
                }

                // If operators not found
                if (flag == true) {
                    return 1;
                }
            } else {
                st.push(ch); // push open parenthesis '(',
            }                // operators and operands to stack
        }
        return 0;


    }

    public static void main(String[] args) {
        String str="(a + (a + b))";
        System.out.println(braces(str));
    }
}
