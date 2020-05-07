package Tree;

public class IfBalanced {
    public static int isBalanced(Node A) {

        int lh; /* for height of left subtree */

        int rh; /* for height of right subtree */

        /* If tree is empty then return true */
        if (A == null)
            return 1;

        /* Get the height of left and right sub trees */
        lh = height(A.left);
        rh = height(A.right);

        if (Math.abs(lh - rh) <= 1 && isBalanced(A.left) ==1& isBalanced(A.right)==1)
            return 1;

        /* If we reach here then tree is not height-balanced */
        return 0;

    }
    static int height(Node node)
    {
        /* base case tree is empty */
        if (node == null)
            return 0;

        /* If tree is not empty then height = 1 + max of left
         height and right heights */
        return 1 + Math.max(height(node.left), height(node.right));
    }
    public static void main(String[] args) {
        Node root1 = new Node(6);       /*             6        */
        root1.left = new Node(3); /*           /   \      */
        root1.right = new Node(17); /*         3     17     */
        root1.left.left = new Node(0); /*    / \   / \    */
        root1.left.right = new Node(4);
        root1.left.right.right = new Node(5);/*  0   4 11   19   */
        root1.right.left = new Node(11);
        root1.right.right = new Node(19);
        System.out.println(isBalanced(root1));
    }
}
