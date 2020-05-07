package Graph;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WOrdSearchII {
    public static void main(String[] args) {
        String str="AB";
        char [][]ch={{'o','a','a','n'},{'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
        char [][]ch1= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String w[] = {"oath","pea","eat","rain"};
        System.out.println(exist(ch,w));
    }
    public static List<String> exist(char[][] board, String[] words) {
        List<String> str=new ArrayList<>();
        Set<String> s=new HashSet<>();
        for(int k=0;k<words.length;k++){
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++){
                if(exist(board, i, j, words[k], 0))
                    s.add(words[k]);
            }
        }

        for(String stt:s){
            str.add(stt);
        }
        return str;

    }
    private static boolean exist(char[][] board, int i, int j, String word, int ind){
        if(ind == word.length()) return true;
        if(i > board.length-1 || i <0 || j<0 || j >board[0].length-1 || board[i][j]!=word.charAt(ind))
            return false;
        board[i][j]='*';
        boolean result =    exist(board, i-1, j, word, ind+1) ||
                exist(board, i, j-1, word, ind+1) ||
                exist(board, i, j+1, word, ind+1) ||
                exist(board, i+1, j, word, ind+1);
        board[i][j] = word.charAt(ind);
        return result;
    }
}
