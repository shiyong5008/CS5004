import java.util.HashMap;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> mag = new HashMap<>();
        int m = magazine.length();
        int count;
        for (int i=0; i<m; i++) {
            Character ch = magazine.charAt(i);
            count = mag.getOrDefault(ch, 0) + 1;
            mag.put(ch, count);
        }

        int r = ransomNote.length();
        boolean flag = false;
        for (int j=0; j<r; j++) {
            Character ch = ransomNote.charAt(j);
            // flag = false;
            int index = mag.getOrDefault(ch, -1);
            if (index == -1) {
                // return flag;
                return false;
            } else if (index > 0) {
                flag = true;
                index--;
                if (index > 0) {
                    mag.put(ch, index);
                } else {
                    mag.remove(ch);
                }
            }
        }
        return flag;
    }
}

/*
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for (int i = 0; i < magazine.length(); i++) cnt[magazine.charAt(i) - 'a']++; //统计magazine各字符个数
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--cnt[ransomNote.charAt(i) - 'a'] < 0) return false; //若消耗完小于0，说明不够用，直接返回false
        }
        return true;
    }
}

作者：wen-jian-69
        链接：https://leetcode-cn.com/problems/ransom-note/solution/383-shu-jin-xin-javazui-jian-dan-si-lu-b-z36t/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */