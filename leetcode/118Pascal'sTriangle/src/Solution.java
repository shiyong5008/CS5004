import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> out = new ArrayList<>();
        List<Integer> r0 = new ArrayList<>();
        r0.add(1);
        out.add(r0);
        if (numRows == 1) return out;

        List<Integer> r1 = new ArrayList<>();
        r1.add(1);
        r1.add(1);
        out.add(r1);
        if (numRows == 2) return out;

        for (int r = 2; r < numRows; r++) {
            List<Integer> rx = new ArrayList<>();
            rx.add(1);
            for (int i = 1; i < r; i++) {
                rx.add(out.get(r - 1).get(i - 1) + out.get(r - 1).get(i));
            }
            rx.add(1);
            out.add(rx);
        }
        return out;
    }
}
