import java.util.ArrayList;
import java.util.List;

class Solution {
    public static String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) return "0";

        int m = num1.length();
        int n = num2.length();

        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();

        List<List<Integer>> lists = new ArrayList<>();
        int up = 0;

        for (int i = n-1; i >=0; --i) {
            int y = c2[i] - '0';
            List<Integer> list = new ArrayList<>();
            for (int j = m-1; j >=0; --j) {
                int x = c1[j] - '0';
                int cur = (x * y + up) % 10;
                up = (x * y + up) / 10;
                list.add(cur);
            }
            if (up > 0) {
                list.add(up);
                up = 0;
            }
            lists.add(list);
            // System.out.println(lists);
        }

        String sum = "0";
        int l = lists.size();
        for (int k = 0; k < l; ++k) {
            String cur = "";

            int p = lists.get(k).size();
            for (int q = p-1; q >=0; q--) {
                cur = cur + (lists.get(k).get(q));
            }

            //cur.append("0".repeat(k));
            for (int o = k; o > 0; --o) {
                cur = cur + ("0");
            }
            sum = addStrings(sum, cur);
        }
        return sum;
    }

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
        String m = "9";
        String n = "99";
        String res = multiply(m, n);
        System.out.println(res);
    }

}
