package Tree;

import java.util.ArrayList;

public class TwoTreeIdentical {
    public static int isSameTree(Node A,Node B){
        if(A==null&B==null)
            return 1;
        if(A.data==B.data &&isSameTree(A.left,B.left)==1&&isSameTree(A.right,B.right)==1)
            return 1;
        else return 0;
    }
//    public static int isSameTree(Node A,Node B) {
//        ArrayList<Integer> I1=new ArrayList<>();
//        ArrayList<Integer> I2=new ArrayList<>();
//        ArrayList<Integer> P1=new ArrayList<>();
//        ArrayList<Integer> P2=new ArrayList<>();
//        inOrder(A, I1);
//        preOrder(A, P1);
//        inOrder(B, I2);
//        preOrder(B, P2);
//        if(I1.equals(I2)&&P1.equals(P2))
//            return 1;
//        else
//            return 0;
//
//
//    }
//    public static void inOrder(Node A, ArrayList I){
//        if(A==null)
//            return;
//        inOrder(A.left,I);
//        I.add(A.data);
//        inOrder(A.right,I);
//    }
//    public static void preOrder(Node A, ArrayList P){
//        if(A==null)
//            return;
//        inOrder(A.left,P);
//        P.add(A.data);
//        inOrder(A.right,P);
//    }
    public static void main(String[] args) {
        Node root1 = new Node(6);       /*             6        */
        root1.left = new Node(3); /*           /   \      */
        root1.right = new Node(17); /*         3     17     */
        root1.left.left = new Node(0); /*    / \   / \    */
        root1.left.right = new Node(4); /*  0   4 11   19   */
        root1.right.left = new Node(11);
        root1.right.right = new Node(19);

        // formation of BST 2
        Node root2 = new Node(8);        /*           8           */
        root2.left = new Node(5); /*           /   \        */
        root2.right = new Node(13); /*        5     13      */
        root2.left.left = new Node(1); /*    / \            */
        root2.left.right = new Node(7); /*  1  7            */
        System.out.println(isSameTree(root1,root2));
    }
}
