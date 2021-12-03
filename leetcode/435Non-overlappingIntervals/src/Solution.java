import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });

        int cnt = 1;
        int r = intervals[0][1];

        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] >= r) {
                ++cnt;
                r = intervals[i][1];
            }
        }
        return intervals.length - cnt;
    }
}
