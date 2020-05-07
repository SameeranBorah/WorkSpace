package Tree;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Contacts {
    /*
     * Complete the contacts function below.
     */
    public static class TrieNode{
        HashMap<Character,TrieNode> child=new HashMap<>();
        boolean isLast;
        TrieNode(){
            child=new HashMap<>();
            isLast=false;
        }
    }
    static TrieNode root=new TrieNode();
    static int[] contacts(String[][] queries) {
        /*
         * Write your code here.
         */
        ArrayList<Integer> arr=new ArrayList<>();
        for (String[] query : queries) {
            if (query[0].equals("add")) {
                add(root,query[1],0,query[1].length());
            }
            if (query[0].equals("find")) {
                System.out.println(find(root,query[1],0,query[1].length()));
            }
        }
        int []a=new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            a[i]=arr.get(i);
        }
        return a;
    }
    private static void add(TrieNode current,String str, int s, int e){
        if(s==e){
            current.isLast=true;
            return;}
        else {
            TrieNode newNode = current.child.get(str.charAt(s));
            if(newNode==null){
                newNode=new TrieNode();
                current.child.put(str.charAt(s),newNode);
            }
            add(newNode,str,s+1,e);
        }
    }
    static int n;
    private static int find(TrieNode current,String str,int s,int e){
        if(s==e)
        {
            n=0;
            return countLast(current,str);
        }
        TrieNode newNode=current.child.get(str.charAt(s));
        if(newNode==null)
            return 0;
        return find(newNode,str,s+1,e);
    }
    private static int countLast(TrieNode current,String str){
        if (current.isLast)
            n++;

        for (char i = 'a'; i <= 'z'; i++) {
            TrieNode nextNode = current.child.get(i);
            if (nextNode != null)
            {
                countLast(nextNode, str + i);
            }
        }
        return n;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            System.out.println(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                System.out.println();
            }
        }


    }
}
