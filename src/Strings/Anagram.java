package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram {
    public static void main(String[] args) {
        List<String> arr= new ArrayList<>();
        arr.add("cat");
        arr.add("dog");
        arr.add("god");
        arr.add("tac");
        System.out.println(anagrams(arr));

    }
    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

        for(int i = 0; i < a.size(); i++){
            char[] c = a.get(i).toCharArray();
            Arrays.sort(c);
            String t = String.valueOf(c);
            if(map.get(t) == null){
                ArrayList<Integer> l = new ArrayList<Integer>();
                l.add(i+1);
                map.put(t, l);
            }
            else
                map.get(t).add(i + 1);
        }
        for(ArrayList<Integer> l : map.values()){
            // if(l.size() > 1) {
            result.add(l);
            //}
        }

        return result;
    }
}
