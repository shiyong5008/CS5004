class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        for (int i = 0; i < n/2; ++i) {
            for (int j = 0; j < n; ++j) {
                int a = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = a;
            }
        }

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int a = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = a;
            }
        }

    }
}
