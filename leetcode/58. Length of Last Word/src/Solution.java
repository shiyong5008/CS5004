import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int lengthOfLastWord(String s) {

        /*
        List<String> str = new ArrayList<>(Arrays.asList(s.split(" ")));
        return str.get(str.size()-1).length();

         */

        int n = s.length();
        int count = 0;

        int i = n-1;
        while (s.charAt(i) == ' ') {
            --i;
        }
        while (i >= 0 && s.charAt(i) != ' ') {
            ++count;
            --i;
        }

        return count;

    }
}
