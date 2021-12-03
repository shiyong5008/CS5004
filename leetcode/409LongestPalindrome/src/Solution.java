import java.util.HashMap;

class Solution {
    public int longestPalindrome(String s) {


        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char x = s.charAt(i);
            int cnt = map.getOrDefault(x, 0) + 1;
            map.put(x, cnt);
        }

        int duel = 0;
        int flag = 0;
        for (int val : map.values()) {
            duel = val / 2 + duel;
            if (val % 2 == 1) {
                flag = flag + 1;
            }
        }
        return flag > 0 ? 2 * duel + 1 : 2* duel;
    }
}

/*

class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/longest-palindrome/solution/zui-chang-hui-wen-chuan-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */
