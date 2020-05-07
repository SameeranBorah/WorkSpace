package Miscellaneous;

import Graph.AllNodesAtK;

import java.util.*;

public class Biweekly22 extends AllNodesAtK {
    public static void main(String[] args) {
       String s1 = "fihjjjjei";
        String s2 = "hjibagacbhadfaefdjaeaebgi";
        System.out.println(canConstruct(s1,s2));
    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<magazine.length();i++){
            if(map.containsKey(magazine.charAt(i))){
                map.put(magazine.charAt(i),map.get(magazine.charAt(i))+1);
            }
            else
                map.put(magazine.charAt(i),1);
        }
        System.out.println(map);
        for(int i=0;i<ransomNote.length();i++){
            if(map.containsKey(ransomNote.charAt(i))&&map.get(ransomNote.charAt(i))>0){
                map.put(ransomNote.charAt(i),map.get(ransomNote.charAt(i))-1);
            }
            else
                return false;
        }

        return true;

    }
    public static void rotate(ArrayList<ArrayList<Integer>> a) {
        ArrayList<Integer> temp;
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>(a.size());
        for(int i=0;i<a.size();i++){
            temp=new ArrayList<>(a.size());
            for(int j=0;j<a.size();j++){

                temp.add(a.get(j).get(a.size()-i));


            }
            arr.add(temp);

        }
        a.clear();
        for(int i=0;i<arr.size();i++)
            a.add(arr.get(i));
        System.out.println(a);
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=0;
        List<Boolean> l=new ArrayList<>(candies.length);
        for(int i=0;i<candies.length;i++){
            if(candies[i]>max)
                max=candies[i];
        }
        for(int i=0;i<candies.length;i++) {
            if(candies[i]+extraCandies>max){
                l.add(true);
            }
            else
                l.add(false);
        }
        return l;
    }
    public static boolean checkIfCanBreak(String s1, String s2) {

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0;i<a.length-1;i++){
            if(a[i]>b[i]){
                for(int j=i+1;j<a.length;j++){
                    if(a[j]<b[j])
                        return false;
                }
            }
            else if(b[i]>a[i]){
                for(int j=i+1;j<a.length;j++){
                    if(b[j]<a[j])
                        return false;
                }
            }

        }
        return true;


    }
    public static ArrayList<ArrayList<Integer>> levelOrder(AllNodesAtK.TreeNode A) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        Queue<AllNodesAtK.TreeNode> q=new ArrayDeque<>();
        q.add(A);
        arr.add(new ArrayList<>(A.val));
        ArrayList<Integer> a;
        while(!q.isEmpty()){
            int levelSize=q.size();
            a=new ArrayList<>();
            while(levelSize>0){
                TreeNode temp=q.poll();
                a.add(temp.val);
                q.add(temp.left);
                q.add(temp.right);
                levelSize--;
            }
            arr.add(a);
            
        }
        return arr;
    }

}
