class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 1 && n == 1) {
            if (target == matrix[0][0]) return true;
            else return false;
        }

        int top = 0, bottom = m-1;
        while (top <= bottom) {
            int mid = (top+bottom)/2;
            if (target >= matrix[mid][0]) {
                top = mid + 1;
            }
            else {
                bottom = mid - 1;
            }
        }
        int index = bottom;
        if (bottom < 0) index = 0;


        int left = 0, right = n-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if (target < matrix[index][mid]) {
                right = mid - 1;
            }
            else if (target > matrix[index][mid]) {
                left = mid + 1;
            }
            else {
                return true;
            }
        }

        return false;

    }
}
