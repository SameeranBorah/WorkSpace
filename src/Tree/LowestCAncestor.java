package Tree;

public class LowestCAncestor {
    public static void main(String[] args) {

        Node root1 = new Node(6);       /*             6        */
        root1.left = new Node(3); /*           /   \      */
        root1.right = new Node(17); /*         3     17     */
        root1.left.left = new Node(0); /*    / \   / \    */
        root1.left.right = new Node(4); /*  0   4 11   19   */
        root1.right.left = new Node(11);
        root1.right.right = new Node(19);
        System.out.println(lca(root1, 99,99));
    }
    public static int lca(Node A, int B, int C) {
        if(lcaHelp(A,B,C)==null)
            return 0;
        return lcaHelp(A,B,C).data;
    }
    public static Node lcaHelp(Node root, int n1, int n2){
        if(root == null){
            return null;
        }
        if(root.data == n1 || root.data == n2){
            return root;
        }

        Node left = lcaHelp(root.left, n1, n2);
        Node right = lcaHelp(root.right, n1, n2);


        if(left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
}
