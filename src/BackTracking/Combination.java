package BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;

public class Combination {
    public static void main(String[] args) {
        System.out.println(combine(4,3));
    }
    public static ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        comb(A,1,B,result,new ArrayList<>());
        return result;

    }
    static void comb(int A,int start,int depth,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> arr) {
        if(depth==0) {
            result.add(new ArrayList<>(arr));
            return ;
        }
        for(int i=start;i<A+1;i++) {
            arr.add(i);
            comb(A,i+1,depth-1,result,arr);
            arr.remove(Integer.valueOf(i));
        }
    }

}
