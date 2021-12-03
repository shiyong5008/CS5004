public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) {
            return strs[0];
        }

        int min = strs[0].length();
        for(int s=0; s<strs.length-1; s++) {
            if(min>strs[s+1].length()) {
                min = strs[s+1].length();
            }
        }

        String res = "";
        for(int i=0; i<min; i++) {
            int flag = 1;
            int j = 0;
            while(flag == 1 && j<strs.length-1) {
                if (strs[j].charAt(i) == strs[j + 1].charAt(i)) {
                    flag = 1;
                } else {
                    flag = 0;
                }
                j++;
            }
            if(flag == 1) {
                res = res + strs[0].charAt(i);
            }else {
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flignt"};
        String out = longestCommonPrefix(strs);
        System.out.println(out);

        String[] strs2 = {"kflower", "mflow", "flignt"};
        String out2 = longestCommonPrefix(strs2);
        System.out.println(out2);

        String[] strs3 = {"kflower"};
        String out3 = longestCommonPrefix(strs3);
        System.out.println(out3);

        String[] strs4 = {"ab", "a"};
        String out4 = longestCommonPrefix(strs4);
        System.out.println(out4);

        String[] strs5 = {"flower", "flower"};
        String out5 = longestCommonPrefix(strs5);
        System.out.println(out5);
    }
}

/*
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String ans = strs[0];
        for(int i =1;i<strs.length;i++) {
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.equals(""))
                return ans;
        }
        return ans;
    }
}

作者：guanpengchn
        链接：https://leetcode-cn.com/problems/longest-common-prefix/solution/hua-jie-suan-fa-14-zui-chang-gong-gong-qian-zhui-b/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


 */