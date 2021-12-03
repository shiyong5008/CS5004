import java.util.*;

class Solution {
    public String frequencySort(String s) {

        /* fail
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            int cnt = map.getOrDefault(c, 0) + 1;
            map.put(c, cnt);
        }

        int valCnt = 0;
        for (int v : map.values()) {
            ++valCnt;
        }

        int[] val = new int[valCnt];
        int i = 0;
        for (int v : map.values()) {
            val[i] = v;
            ++i;
        }
        Arrays.sort(val);

        List<Character> list = new ArrayList<>();
        for (int k = 0; k < valCnt; ++k) {
            for (Map.Entry<Character, Integer> e : map.entrySet()) {
                if (valCnt>-1 && e.getValue() == val[valCnt - 1]) {
                    for (int j = val[valCnt - 1]; j > 0; --j) {
                        list.add(e.getKey());
                    }
                    --valCnt;
                }
            }
        }

        return list.toString();

         */

        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            int cnt = map.getOrDefault(c, 0) + 1;
            map.put(c, cnt);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        StringBuffer ans = new StringBuffer();
        int l = list.size();
        for (int i = 0; i < l; ++i) {
            char c = list.get(i);
            int count = map.get(c);
            for (int j = 0; j < count; ++j) {
                ans.append(c);
            }
        }

        return ans.toString();

    }
}
