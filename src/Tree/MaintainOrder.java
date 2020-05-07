package Tree;

import java.util.ArrayList;

public class MaintainOrder {
    public static int[] recoverTree(Node A) {
        ArrayList<Integer> Arr=new ArrayList<>();
        inOrder(A,Arr);
        System.out.println(Arr);
        int a[]=new int[2];
        int i;
        for(i=0;i<Arr.size()-1;i++){
            if(Arr.get(i)>Arr.get(i+1)){
                a[1]=Arr.get(i);
                break;}
        }
//        if(Arr.size()==2){
//            a[0]=Arr.get(1);
//            a[1]=Arr.get(0);
//            return a;
//        }
        System.out.println(i);
        for(int j=i+1;j<Arr.size()-1;j++){
            if(Arr.get(j+1)<Arr.get(j)){
                a[0]=Arr.get(j+1);
                return a;
            }
           // a[0]=Arr.get(i+1);
        }
        a[0]=Arr.get(i+1);
        System.out.println(Arr);
        return a;

    }

    public static void inOrder(Node A, ArrayList<Integer> Arr){
        if(A==null)
            return;
        inOrder(A.left,Arr);
        Arr.add(A.data);
        inOrder(A.right,Arr);

    }
    public static void main(String[] args) {
        Node root1 = new Node(3);       /*             6        */
        root1.left = new Node(6); /*           /   \      */
//        root1.right = new Node(11); /*         3     17     */
//        root1.left.left = new Node(0); /*    / \   / \    */
//        root1.left.right = new Node(4); /*  0   4 11   19   */
//        root1.right.left = new Node(17);
//        root1.right.right = new Node(19);
        //   System.out.println(hasPathSum(root1,42));
        int Arr[]=recoverTree(root1);
        System.out.println(Arr[0]+" "+Arr[1]);
    }
}
