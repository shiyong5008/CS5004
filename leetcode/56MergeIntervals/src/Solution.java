import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // Arrays.sort(intervals, (a,b) -> a[0]-b[0]);

//        int n = intervals.length;

        List<int[]> res = new ArrayList<>();

//        for (int i = 0; i < n; ++i) {
//            int l = intervals[i][0], r = intervals[i][1];

        for (int[] interval : intervals) {
            int l = interval[0], r = interval[1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < l) {
                res.add(new int[]{l, r});
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], r);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
