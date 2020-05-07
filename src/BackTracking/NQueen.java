package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            backtrack(i,0,result,n);
        }
       return result;
    }
    private static void backtrack(int initial, int level, List<List<String>> result, int n){
        if(level==n-1){

        }
        else{

        }
    }

}
