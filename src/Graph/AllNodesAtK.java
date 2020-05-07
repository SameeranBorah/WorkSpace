package Graph;

import Miscellaneous.RottenOranges;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class AllNodesAtK {
    static int max;
    static int [][] matrix;
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(3); /*             6        */
        root1.left = new TreeNode(5); /*           /   \      */
        root1.right = new TreeNode(1); /*         3     17     */
        root1.left.left = new TreeNode(6); /*    / \   / \    */
        root1.left.right = new TreeNode(2); /*  0   4 11   19   */
        root1.right.left = new TreeNode(0);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);
        System.out.println(distanceK(root1, root1.left,2));
    }
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        TreeNode temp=root;
        max=findMax(temp);
        matrix=new int[max+1][max+1];
        aMatrix(root);
        List<Integer> result=new ArrayList<>();
        return bfs(target,K,result);
    }
    public static int findMax(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(root.val,Math.max(findMax(root.left),findMax(root.right)));
    }
    public static void aMatrix(TreeNode root) {
        if (root==null)
            return ;
        aMatrix(root.left);
        aMatrix(root.right);
        if (root.left != null)
        {
            matrix[root.val][root.left.val] = 1;
            matrix[root.left.val][root.val] = 1;
        }
        if (root.right != null)
        {
            matrix[root.val][root.right.val] = 1;
            matrix[root.right.val][root.val] = 1;
        }

    }
    public static List<Integer> bfs(TreeNode target, int k, List<Integer> results){
        boolean[] visited = new boolean[matrix.length];

        visited[target.val] = true;

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(target.val);
        while(k>0) {
            int levelOrder = queue.size();
            while (levelOrder > 0){
                levelOrder--;
                int x = queue.poll();
                int i;
                for (i = 0; i < matrix.length; i++) {
                    if (matrix[x][i] == 1 && visited[i] == false) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
            k--;
        }
        while (!queue.isEmpty())
            results.add(queue.poll());
        return results;
    }
}
