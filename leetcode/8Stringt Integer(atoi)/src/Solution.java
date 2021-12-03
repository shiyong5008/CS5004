class Solution {
    public static int myAtoi(String s) {
        int o = 0;
        long res = 0;
        int f = 0;
        int pn = 1;
        int flagSign = 1;
        int flagSpace = 1;
        int i=0;
        while(i<s.length()) {
            int k = Integer.valueOf(s.charAt(i));
            // int kn= Integer.valueOf(s.charAt(i+1));
            if(k==32 && flagSpace==1) {
                i++;
            // } else if(k==43 && kn>=48 && kn<=57 && flag ==1) {
            } else if(k==43 && flagSign ==1) {
                pn = 1;
                flagSign = 0;
                flagSpace = 0;
                i++;
            // } else if(k==45 && kn>=48 && kn<=57 && flag ==1) {
            } else if(k==45 && flagSign ==1) {
                pn = 0;
                flagSign = 0;
                flagSpace = 0;
                i++;
            } else if(k>=48 && k<=57) {
                o=s.charAt(i)-'0';

                if(pn==1 && (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && o>Integer.MAX_VALUE%10))){
                    return Integer.MAX_VALUE;
                }

                if(pn==0 && (-res < Integer.MIN_VALUE/10 || (-res == Integer.MIN_VALUE/10 && -o<Integer.MIN_VALUE%10))){
                    return Integer.MIN_VALUE;
                }
                res=res*10+o;
                i++;
                flagSign = 0;
                flagSpace = 0;
            } else {
                break;
            }
        }

        if(pn==1) {
            res = res;
        } else if(pn==0) {
            res = - res;
        }

        f= (int) res;
        return f;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("000-123x"));
        System.out.println(myAtoi("   4 6-123x"));
        System.out.println(myAtoi("   -0123x123"));
        System.out.println(myAtoi("   +123x"));
        System.out.println(myAtoi("-123x"));
        System.out.println(myAtoi("+123x"));
        System.out.println(myAtoi(" 123x"));
        System.out.println(myAtoi("w123x"));
        System.out.println(myAtoi("   --123x"));
        System.out.println(myAtoi("   ++123x"));
        System.out.println(myAtoi("091283472332"));
        System.out.println(myAtoi("-091283472332"));
        System.out.println(myAtoi("2147483647"));
        System.out.println(myAtoi("-2147483648"));
        System.out.println(myAtoi("2147483646"));
        System.out.println(myAtoi("-2147483649"));
        System.out.println(Integer.MIN_VALUE%10);
    }

}

/*
方法一：自动机
        思路

        字符串处理的题目往往涉及复杂的流程以及条件情况，如果直接上手写程序，一不小心就会写出极其臃肿的代码。

        因此，为了有条理地分析每个输入字符的处理方法，我们可以使用自动机这个概念：

        我们的程序在每个时刻有一个状态 s，每次从序列中输入一个字符 c，并根据字符 c 转移到下一个状态 s'。这样，我们只需要建立一个覆盖所有情况的从 s 与 c 映射到 s' 的表格即可解决题目中的问题。

        算法

        本题可以建立如下图所示的自动机：



        我们也可以用下面的表格来表示这个自动机：

        ' '	+/-	number	other
        start	start	signed	in_number	end
        signed	end	end	in_number	end
        in_number	end	end	in_number	end
        end	end	end	end	end
        接下来编程部分就非常简单了：我们只需要把上面这个状态转换表抄进代码即可。

        另外自动机也需要记录当前已经输入的数字，只要在 s' 为 in_number 时，更新我们输入的数字，即可最终得到输入的数字。

        Python3C++Java

class Solution {
    public int myAtoi(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }
}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}

作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/string-to-integer-atoi/solution/zi-fu-chuan-zhuan-huan-zheng-shu-atoi-by-leetcode-/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


 */