import java.util.HashSet;
import java.util.Set;


/*
public class Solution {

    /*
    public static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 暴力解法
    public static String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++)
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = s.substring(i, j);
                    max = Math.max(max, ans.length());
                }
            }
        return ans;
    }

     */

    /*
    public static String longestPalindrome(String s) {
            if (s == null || s.length() < 1) {
        return "";
    }
    int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
        return s.substring(start, end + 1);
}

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }




    public static void main(String[] args) {
        String s = "abcabcbb";
        String k = longestPalindrome(s);
        System.out.println(k);
    }
}
*/

class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();
        if (n < 2) return s;
        int max = 1;
        int start = 0;
        int end = 0;
        int l = 0;
        int r = 0;

        for (int i = 0; i < n; ++i) {

            start = i;
            end = i;

            while (end<n-1 && s.charAt(end) == s.charAt(end+1)) {
                ++end;
            }

            while (start>=0 && end<n && s.charAt(start) == s.charAt(end)) {
                --start;
                ++end;
            }
            if (end - start + 1 - 2 > max) {
                max = end - start + 1 - 2;
                l = start + 1;
                r = end - 1;
            }
        }
        return s.substring(l, r+1);
    }
}