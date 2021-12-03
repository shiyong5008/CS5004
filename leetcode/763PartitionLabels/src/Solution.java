import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {

        /*
        int[] letter = new int[26];

        for (int i = 0; i < s.length(); ++i) {
            letter[s.charAt(i)-'a'] = i;
        }

        List<Integer> list = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); ++i) {
            end = Math.max(end, letter[s.charAt(i)-'a']);
            if (i == end) {
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;

         */

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            map.put(s.charAt(i), i);
        }

        List<Integer> list = new ArrayList<>();
        int end = 0, start = 0;
        for (int i = 0; i < s.length(); ++i) {
            end = Math.max(end, map.get(s.charAt(i)));
            if (i == end) {
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }
}
