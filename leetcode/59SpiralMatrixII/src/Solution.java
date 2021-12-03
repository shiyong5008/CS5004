class Solution {
    public int[][] generateMatrix(int n) {

        int top = 0, bottom = n-1, left = 0, right = n-1;
        int[][] matrix = new int[n][n];

        int m = 1;
        while (m <= n*n) {
            for (int i = left; i <= right; ++i) {
                matrix[top][i] = m;
                ++m;
            }
            ++top;

            for (int i = top; i <= bottom; ++i) {
                matrix[i][right] = m;
                ++m;
            }
            --right;

            for (int i = right; i >= left; --i) {
                matrix[bottom][i] = m;
                ++m;
            }
            --bottom;

            for (int i = bottom; i >= top; --i) {
                matrix[i][left] = m;
                ++m;
            }
            ++left;
        }

        return matrix;
    }
}
