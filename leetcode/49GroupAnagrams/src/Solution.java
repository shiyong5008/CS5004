import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> lists = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String k = Arrays.toString(c);
            if (map.containsKey(k)) {
                map.get(k).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(k, list);
            }
        }

        for (List<String> x : map.values()) {
            lists.add(x);
        }
        return lists;
    }
}
