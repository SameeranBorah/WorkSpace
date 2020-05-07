package Tree;

public class Depth {
    public static void main(String[] args) {
        Node root1 = new Node(6); /*                     6        */
        root1.left = new Node(3); /*                  /   \      */
        root1.right = new Node(17); /*               3     17     */
        root1.left.left = new Node(0); /*           / \   / \    */
        root1.left.right = new Node(4);/*           0   4 11   19   */
        root1.left.right.right = new Node(9);/*           9         */
        root1.right.left = new Node(11);
        root1.right.right = new Node(19);
        //printLeaf(root1);
        //   System.out.println(hasPathSum(root1,42));
        System.out.println(maxDepth(root1));
    }
    public static int maxDepth(Node root){

        if(root==null){
            return 0;
        }
        return Math.min(maxDepth(root.left), maxDepth(root.right))+1;

    }
}
