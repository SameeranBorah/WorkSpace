package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        List<Integer> queenCols = new ArrayList<>(n);

        backtrack(0, n, queenCols, solutions);

        return solutions;
    }

    private void backtrack(int startRow, int n, List<Integer> queenCols, List<List<String>> solutions) {
        for (int row = startRow; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (canPlaceQueen(row, col, queenCols)) {
                    queenCols.add(col);

                    if (queenCols.size() == n) {
                        solutions.add(convertSolution(n, queenCols));
                    } else {
                        backtrack(row + 1, n, queenCols, solutions);
                    }

                    queenCols.remove(queenCols.size() - 1);
                }
            }
        }
    }

    private boolean canPlaceQueen(int row, int col, List<Integer> queenCols) {
        for (int queenRow = 0; queenRow < queenCols.size(); queenRow++) {
            int queenCol = queenCols.get(queenRow);

            if (row == queenRow || col == queenCol || Math.abs(row - queenRow) == Math.abs(col - queenCol)) {
                return false;
            }
        }
        return true;
    }

    private List<String> convertSolution(int n, List<Integer> queenCols) {
        List<String> solution = new ArrayList<>(n);
        for (int row = 0; row < n; row++) {
            StringBuilder rowBuilder = new StringBuilder(n);
            for (int col = 0; col < n; col++) {
                rowBuilder.append(queenCols.get(row) == col ? 'Q' : '.');
            }
            solution.add(rowBuilder.toString());
        }
        return solution;
    }
}
