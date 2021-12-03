class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length;
        int n = mat[0].length;
        int[][] out = new int[r][c];

        if (m*n != r*c) {
            return mat;
        } else {
            for (int i=0; i<m*n; i++) {
                out[i/c][i%c] = mat[i/n][i%n];
            }
        }
        return out;
    }
}
