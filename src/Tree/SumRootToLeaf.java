package Tree;

import java.util.ArrayList;
import java.util.Stack;

public class SumRootToLeaf {
    public static void main(String[] args) {
        Node root1 = new Node(6);       /*             6        */
        root1.left = new Node(3); /*           /   \      */
        root1.right = new Node(17); /*         3     17     */
        root1.left.left = new Node(0); /*    / \   / \    */
        root1.left.right = new Node(4); /*  0   4 11   19   */
        root1.right.left = new Node(11);
        root1.right.right = new Node(19);
        System.out.println(sumNumbers(root1));
    }
    private static ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

    public static void pathSumInner(Node root,  Stack<Integer> path) {
        path.push(root.data);

        if(root.left == null && root.right == null) {
           resultList.add(new ArrayList<Integer>(path));
        }

        if(root.left!=null) pathSumInner(root.left, path);
        if(root.right!=null)pathSumInner(root.right, path);

        path.pop();
    }

    public static int sumNumbers(Node A) {
        if(A==null) return 0;
        Stack<Integer> path = new Stack<Integer>();
        pathSumInner(A, path);
        System.out.println(resultList);
        for(int i=0;i<resultList.size();i++){
            for(int j=1;j<resultList.get(i).size();j++){
                resultList.get(i).set(j,resultList.get(i).get(j-1)*10%1003+resultList.get(i).get(j)%1003);
            }
            if(i>0){
                resultList.get(i).set(resultList.get(i).size()-1,resultList.get(i-1).get(resultList.get(i-1).size()-1)+resultList.get(i).get(resultList.get(i).size()-1));
            }
        }

        System.out.println(resultList);
        //return 0;
       return resultList.get(resultList.size()-1).get(resultList.get(resultList.size()-1).size()-1)%1003;
    }
}
