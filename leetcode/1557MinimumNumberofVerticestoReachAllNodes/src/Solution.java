import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (List<Integer> x : edges) {
            set.add(x.get(1));
        }

        for (int i = 0; i < n; ++i) {
            if (!set.contains(i)) {
                res.add(i);
            }
        }

        return res;

    }
}
