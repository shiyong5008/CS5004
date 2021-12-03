
/* over time
class Solution {
    public int strStr(String haystack, String needle) {

        int h = haystack.length();
        int n = needle.length();
        if (n == 0) return 0;
        if (h < n) return -1;

        for (int i = 0; i < h; ++i) {
            int j = 0;
            int k = i;
            while (k < h && haystack.charAt(k) == needle.charAt(j)) {
                ++k;
                ++j;
                if (j == n) {
                    return k - j;
                }
            }
        }

        return -1;

    }
}

 */


class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}

