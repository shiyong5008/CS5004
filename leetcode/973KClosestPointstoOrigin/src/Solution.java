import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        Arrays.sort(points, (a,b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));

        int[][] ans = new int[k][];

        for (int i = 0; i < k; ++i) {
            ans[i] = points[i];
        }
        // System.arraycopy(points, 0, ans, 0, k);

        return ans;

    }
}
