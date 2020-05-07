package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.RecursiveAction;


public class ShortestUniquePrefix {
    static class TrieNode
    {
        HashMap<Character,TrieNode> child;
        boolean isLast;
        TrieNode(){
            child=new HashMap<>();
            isLast=false;
        }
    }
    static TrieNode root=new TrieNode();
    static ArrayList<String> res=new ArrayList<>();
    public static ArrayList<String> prefix(ArrayList<String> A) {
        recursiveInsert(A);
        System.out.println(search("zebra"));
        return null;

    }
    public static boolean search(String str){
       return(search(root,str,0));

    }


    public static boolean search(TrieNode root,String str, int l){
        if(str.length()==l){
            return root.isLast;
        }
        TrieNode test=root.child.get(str.charAt(l));
        if(test==null){
            return false;
        }
        return search(test,str,l+1);
    }

    /**
     *
     * Iterative insert
     */
    public static void insert(ArrayList<String> A){
        for(int i=0;i<A.size();i++){
            TrieNode current=root;
            for(int j=0;j<A.get(i).length();j++){
                    TrieNode newNode=current.child.get(A.get(i).charAt(j));
                    if(newNode==null){
                        newNode=new TrieNode();
                        current.child.put(A.get(i).charAt(j),newNode);
                    }
                    current=newNode;
            }

            current.isLast=true;
        }
    }

    /**
     *
     * recursive insert
     */
    public static void recursiveInsert(ArrayList<String> A){
        for(int i=0;i<A.size();i++){
            recursiveInsert(root,A.get(i),0);
        }
    }
    public static void recursiveInsert(TrieNode current, String str, int index){
        if(index==str.length()){
            current.isLast=true;
            return;
        }
        TrieNode newNode=current.child.get(str.charAt(index));
        if(newNode==null){
            newNode=new TrieNode();
            current.child.put(str.charAt(index),newNode);
        }
        recursiveInsert(newNode,str,index+1);
    }
    public static void main(String[] args) {
        ArrayList<String> Arr=new ArrayList<>();

        Arr.add("bearcatv");
        Arr.add("bert");
        Arr.add("dogger");
        Arr.add("duck");
        Arr.add("dove");
        System.out.println(prefix(Arr));
        //prefix(Arr);
    }
}