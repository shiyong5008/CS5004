import java.util.ArrayList;
import java.util.List;

class Solution {
    public static String addStrings(String num1, String num2) {

        int m = num1.length();
        int n = num2.length();
        if (m > n) return addStrings(num2, num1);
        // System.out.println(num1);

        List<Integer> list = new ArrayList<>();
        int p = n - m;
        int add = 0;
        int up = 0;
        char x = '0';

        for (int i = n-1; i >=0; --i) {
            char y = num2.charAt(i);
            if (i-p >= 0) {
                x = num1.charAt(i - p);
            } else {
                x = '0';
            }

            add = ((y - '0') + (x - '0') + up)%10;
            up = ((y - '0') + (x - '0') + up)/10;
            // System.out.println(up);

            list.add(add);
        }
        if (up > 0) {
            list.add(up);
        }

        String res = "";
        for (int i = list.size() - 1; i >= 0; --i) {
            res = res + list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String m = "584";
        String n = "18";
        System.out.println(addStrings(m,n));
    }
}


/*

class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/add-strings/solution/zi-fu-chuan-xiang-jia-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

 */
