import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[k];
        List<Integer> list = new ArrayList<>();

        for (int x : nums) {
            int cnt = map.getOrDefault(x, 0) + 1;
            map.put(x, cnt);
        }

        for (int v : map.values()) {
            list.add(v);
        }

        Collections.sort(list);
        int n = list.size();

        int key = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() >= list.get(n-k)) {
                if (key < k) {
                    ans[key] = e.getKey();
                    ++key;
                } else break;
            }
        }

        return ans;

    }
}
