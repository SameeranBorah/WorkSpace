package Tree;

import java.util.ArrayList;
import java.util.List;

class Node {

    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {


    static List<Integer> arr=new ArrayList<>();
    public static List<Integer> inOrder(Node root){

        if(root==null)
            return null;
        inOrder(root.left);
        arr.add(root.data);
        inOrder(root.right);
        return arr;
    }

    public static void sumCheck(Node root1 ,Node root2,int x) {
        if(root1==null)
            return;
        if(root2==null)
            return;
        sumCheck(root1.left,root2.right,x);
        if(root1.data+root2.data==x)
            System.out.println(root1.data+" "+root2.data);
        sumCheck(root1.right,root2.left,x);

    }


    static Node root1;
    static Node root2;
    public static void main(String args[])
    {
        // formation of BST 1
        root1 = new Node(6);       /*             6        */
        root1.left = new Node(3); /*           /   \      */
        root1.right = new Node(17); /*         3     17     */
        root1.left.left = new Node(0); /*    / \   / \    */
        root1.left.right = new Node(4); /*  0   4 11   19   */
        root1.right.left = new Node(11);
        root1.right.right = new Node(19);

        // formation of BST 2
        root2 = new Node(8);        /*           8           */
        root2.left = new Node(5); /*           /   \        */
        root2.right = new Node(13); /*        5     13      */
        root2.left.left = new Node(1); /*    / \            */
        root2.left.right = new Node(7); /*  1  7            */

        Node root3 = new Node(0);
        int x = 18;
        sumCheck(root1,root2,x);
        System.out.println(inOrder(root3));

    }
} 