import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        int n = s.length();

        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        if (n < 10) return list;

        for (int i = 0; i < n-9; ++i) {
            String temp = s.substring(i, i+10);
            int cnt = map.getOrDefault(temp, 0) + 1;
            if (cnt == 2) {
                list.add(temp);
            }
            map.put(temp, cnt);
        }
        return list;
    }
}
