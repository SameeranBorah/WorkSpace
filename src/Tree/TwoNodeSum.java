package Tree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoNodeSum {

//     public static int t2Sum(Node A, int B) {
//         List<Integer> map=new ArrayList<>();
//         inorder(A,map);
//        for (int i=0;i<map.size();i++){
//            int x=map.remove(i);
//            if(map.contains(B-x)){
//                return 1;
//            }
//            map.add(x);
//        }
//        return 0;
//
//    }
//    public static void inorder(Node root,List map){
//        if(root != null){
//            inorder(root.left,map);
//            map.add(root.data);
//            inorder(root.right,map);
//        }
//    }
    public static int t2Sum(Node A, int B) {
        Set<Integer> set = new HashSet<>();
        return find (A, set, B);
    }

    public static int find(Node node, Set<Integer> set, int k){
        if(node == null) return 0;

        if(set.contains(k - node.data)) return 1;

        set.add(node.data);
        if(find(node.left, set, k)==1|| find(node.right, set, k)==1)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) {

        Node root1 = new Node(11);       /*             6        */
        root1.left = new Node(4); /*           /   \      */
        root1.right = new Node(1); /*         3     17     */
        root1.left.left = new Node(11); /*    / \   / \    */
        root1.left.right = new Node(-1); /*  0   4 11   19   */
        root1.right.left = new Node(-1);
        root1.right.right = new Node(-1);
        root1.right.right = new Node(-1);
        System.out.println(t2Sum(root1, 15));
    }
}
