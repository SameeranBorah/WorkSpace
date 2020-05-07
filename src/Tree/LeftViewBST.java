package Tree;

import java.io.*;
import java.util.*;

public class LeftViewBST {

    static class Node {
        int data;
        Node left, right;
        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;
        int max_level = 0;
        void createNode(int parent[], int i, Node created[])
        {
            // If this node is already created
            if (created[i] != null)
                return;

            // Create a new node and set created[i]
            created[i] = new Node(i);

            // If 'i' is root, change root pointer and return
            if (parent[i] == -1)
            {
                root = created[i];
                return;
            }

            // If parent is not created, then create parent first
            if (created[parent[i]] == null)
                createNode(parent, parent[i], created);

            // Find parent pointer
            Node p = created[parent[i]];

            // If this is first child of parent
            if (p.left == null)
                p.left = created[i];
            else // If second child

                p.right = created[i];
        }

        /* Creates tree from parent[0..n-1] and returns root of
           the created tree */
        Node createTree(int parent[], int n)
        {
            // Create an array created[] to keep track
            // of created nodes, initialize all entries
            // as NULL
            Node[] created = new Node[n];
            for (int i = 0; i < n; i++)
                created[i] = null;

            for (int i = 0; i < n; i++)
                createNode(parent, i, created);

            return root;
        }

        void leftViewUtil(Node node, int level) {
            // Base Case
            if (node == null)
                return;

            // If this is the first node of its level
            if (max_level < level) {
                System.out.print(" " + node.data);
                max_level = level;
            }

            // Recur for left and right subtrees
            leftViewUtil(node.left, level + 1);
            leftViewUtil(node.right, level + 1);
        }
    }


    public static void main(String[] args) {
        BinaryTree tree= new BinaryTree();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int j = 0; j < n; j++) {
            int m = sc.nextInt();
            int[] numbers = new int[m];

            for (int i = 0; i < m; i++) {
                numbers[i]=sc.nextInt();
            }
            Node node = tree.createTree(numbers,m);
            tree.leftViewUtil(node,2);
        }
    }

}