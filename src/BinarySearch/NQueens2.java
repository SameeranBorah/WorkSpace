package BinarySearch;

public class NQueens2 {
    public int result = 0;
    public boolean[] dialogue1;
    public boolean[] dialogue2;
    public boolean[] column;

    public void recursion(int n, int row){
        if(n == row){
            result += 1;
            return;
        }
        for(int col = 0; col < n; col++){
            if(!column[col] && !dialogue1[col+row] && !dialogue2[row-col+n-1]){
                column[col] = true;
                dialogue1[col+row] = true;
                dialogue2[row-col+n-1] = true;
                recursion(n, row+1);
                column[col] = false;
                dialogue1[col+row] = false;
                dialogue2[row-col+n-1] = false;
            }
        }
    }

    public int totalNQueens(int n) {
        dialogue1 = new boolean[2*n];
        dialogue2 = new boolean[2*n];
        column = new boolean[n];
        recursion(n, 0);
        return result;
    }
}
