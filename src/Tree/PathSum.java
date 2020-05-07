package Tree;

import java.util.ArrayList;
import java.util.Stack;

public class PathSum {
    public static void main(String[] args) {
        Node root1 = new Node(6);       /*             6        */
        root1.left = new Node(3); /*           /   \      */
        root1.right = new Node(17); /*         3     17     */
        root1.left.left = new Node(0); /*    / \   / \    */
        root1.left.right = new Node(4); /*  0   4 11   19   */
        root1.right.left = new Node(11);
        root1.right.right = new Node(19);
        //printLeaf(root1);
     //   System.out.println(hasPathSum(root1,42));
        System.out.println(pathSum(root1,42));
    }
    static int sum=0;
    static int k=0;
//    public static int hasPathSum(Node root,int B){
//
//        pathSum2(root,B);
//        if(k==1)
//            return 1;
//        else
//            return 0;
//
//    }
//    public static void pathSum(Node root,int B){
//        if(root==null)
//            return;
//        sum=sum+root.data;
//        hasPathSum(root.left, B);
//        if(root.left==null&&root.right==null){
//            if(B==sum){
//                k=1;
//            }
//
//        }
//
//        hasPathSum(root.right,B);
//        sum=sum-root.data;
//    }
    public static int hasPathSum(Node root, int sum) {
        if(root==null) return 0;
        int expect=sum-root.data;
        if(expect==0 && root.left==null && root.right==null) return 1;
        int left=hasPathSum(root.left, expect);
        int right=hasPathSum(root.right, expect);
        if(left==1 || right==1){
            return 1;
        }
        else return 0;
    }

    private static ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

    public static void pathSumInner(Node root, int sum, Stack<Integer>path) {
        path.push(root.data);

        if(root.left == null && root.right == null) {
            if(sum == root.data) resultList.add(new ArrayList<Integer>(path));
        }

        if(root.left!=null) pathSumInner(root.left, sum-root.data, path);
        if(root.right!=null)pathSumInner(root.right, sum-root.data, path);

        path.pop();
    }

    public static ArrayList<ArrayList<Integer>> pathSum(Node root, int sum) {
        if(root==null) return resultList;
        Stack<Integer> path = new Stack<Integer>();
        pathSumInner(root, sum, path);
        return resultList;
    }
}
