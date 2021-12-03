import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    /*
    public static void main(String[] args) {
        int[][][] test = new int[3][3][9];

        System.out.println(Arrays.deepToString(test));
    }

     */


    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                if (val == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (row[i] == 1) {
                for (int c = 0; c < n; c++) {
                    matrix[i][c] = 0;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            if (col[j] == 1) {
                for (int r = 0; r < m; r++) {
                    matrix[r][j] = 0;
                }
            }
        }

    }
}
