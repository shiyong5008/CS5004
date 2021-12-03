import java.util.ArrayList;
import java.util.List;


class Solution {
    public int findTheWinner(int n, int k) {

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; ++i) {
            list.add(i);
        }

        int r = 0;
        int l = n;
        for (int j = 1; j <= n-1; ++j) {
            r = (r + k - 1) % l;
            list.remove(r);
            --l;
        }
        return list.get(0);

    }
}

/*
class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + k - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0) + 1;
    }
}
*/


/*
作者：idjack
        链接：https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/solution/java-mo-ni-by-idjack-q2sn/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */

