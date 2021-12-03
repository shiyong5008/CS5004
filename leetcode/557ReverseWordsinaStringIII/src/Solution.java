import java.util.Arrays;

class Solution {
    public String reverseWords(String s) {

        String[] wd = s.split(" ");
        int n = wd.length;
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < n; ++i) {
            char[] tmp = wd[i].toCharArray();
            reverseString(tmp);
            if (i == n-1) {
                ans.append(tmp);
            } else {
                ans.append(tmp);
                ans.append(' ');
            }
        }
        return ans.toString();

    }

    public void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            ++left;
            --right;
        }

    }
}
