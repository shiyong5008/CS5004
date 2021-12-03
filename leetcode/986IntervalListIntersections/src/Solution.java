import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> list = new ArrayList<>();

        int m = firstList.length;
        int n = secondList.length;
        int i = 0, j = 0;

        if (m == 0 || n == 0) return list.toArray(new int[0][]);

        while (i < m && j < n) {

            int[] x = firstList[i];
            int[] y = secondList[j];

            if (x[0] > y[1]) ++j;
            else if (y[0] > x[1]) ++i;
            else {
                int l = Math.max(x[0], y[0]);
                int r = Math.min(x[1], y[1]);
                list.add(new int[] {l, r});

                if (x[1] > y[1]) ++j;
                else if (y[1] > x[1]) ++i;
                else { ++i; ++j; }

            }
        }
        return list.toArray(new int[list.size()][]);

    }
}
