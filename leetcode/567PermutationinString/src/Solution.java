import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int m = s1.length(), n = s2.length();
        if (m > n) return false;
        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (int i = 0; i < m; ++i) {
            ++c1[s1.charAt(i) - 'a'];
            ++c2[s2.charAt(i) - 'a'];
        }
        if (Arrays.equals(c1, c2)) return true;
        for (int i = m; i < n; ++i) {
            --c2[s2.charAt(i - m) - 'a'];
            ++c2[s2.charAt(i) - 'a'];
            if (Arrays.equals(c1, c2)) return true;
        }
        return false;

    }
}
