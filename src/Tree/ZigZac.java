package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

public class ZigZac {
    public static void main(String[] args) {
        Node root1 = new Node(6);       /*             6        */
        root1.left = new Node(3); /*           /   \      */
        root1.right = new Node(17); /*         3     17     */
        root1.left.left = new Node(0); /*    / \   / \    */
        root1.left.right = new Node(4); /*  0   4 11   19   */
        root1.right.left = new Node(11);
        root1.right.right = new Node(19);
        System.out.println(zigzagLevelOrder(root1));
    }
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(Node A) {
        if(A==null)
            return null;
        ArrayList<ArrayList<Integer>> Arr=new ArrayList<>();
        Stack<Node> s1=new Stack<>();
        Stack<Node> s2=new Stack<>();
        Stack<Integer> x1=new Stack<>();
        Stack<Integer> x2=new Stack<>();
        s1.push(A);
        x1.push(A.data);
        Arr.add(new ArrayList<>(x1));
        while(!s1.isEmpty()||!s2.empty()){

            while(!s1.isEmpty()){

                Node P=(s1.pop());
                x1.pop();
                if(P.right!=null) {
                    s2.push(P.right);
                    x2.push(P.right.data);
                }
                if(P.left!=null) {
                    s2.push(P.left);
                    x2.push(P.left.data);
                }
            }
            System.out.println(x2);
            Arr.add(new ArrayList<>(x2));
            while (!s2.isEmpty()){
                Node P=(s2.pop());
                x2.pop();
                if(P.left!=null){
                    s1.push(P.left);
                    x1.push(P.left.data);
                }
                if(P.right!=null){
                    s1.push(P.right);
                    x1.push(P.right.data);
                }
            }
            System.out.println(x1);
            Arr.add(new ArrayList<>(x1));


        }

        if(Arr.get(Arr.size()-1).isEmpty())
            Arr.remove(Arr.size()-1);
        if(Arr.get(Arr.size()-1).isEmpty())
            Arr.remove(Arr.size()-1);
        return Arr;

    }
}
