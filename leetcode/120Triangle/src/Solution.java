import java.util.Arrays;
import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int m = triangle.size();
        int[] store = new int[m];
        store[0] = triangle.get(0).get(0);

        for (int i = 1; i < m; ++i) {
            for (int j = i; j >= 0; --j) {
                if (j == i) {
                    store[j] = triangle.get(i).get(j) + store[j-1];
                }
                else if (j < i && j > 0) {
                    store[j] = triangle.get(i).get(j) + Math.min(store[j], store[j-1]);
                }
                else {
                    store[j] = triangle.get(i).get(j) + store[j];
                }
            }
        }

        /*
        Arrays.sort(store);
        return store[0];
         */
        int min = store[0];
        for (int x : store) {
            if (x < min) min = x;
        }
        return min;

    }
}