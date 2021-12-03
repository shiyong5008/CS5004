class Solution {
    public static int romanToInt(String s) {
        int res = 0;
        s = s + "F";
     //   s="S"+s;

     //   /*
        int flagM = 1;
        int flagD = 1;
        int flagC = 1;
        int flagL = 1;
        int flagX = 1;
        int flagV = 1;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='M' && flagM==1) {
                res = res + 1000;
            }else if(s.charAt(i)=='C' && s.charAt(i+1)=='M') {
                res = res + 900;
                flagM = 0;
            }else if(s.charAt(i)=='D' && flagD == 1) {
                res = res + 500;
            }else if(s.charAt(i)=='C' && s.charAt(i+1)=='D') {
                res = res + 400;
                flagD = 0;
            }else if(s.charAt(i)=='C' && flagC == 1) {
                res = res + 100;
            }else if(s.charAt(i)=='X' && s.charAt(i+1)=='C') {
                res = res + 90;
                flagC = 0;
            }else if(s.charAt(i)=='L' && flagL == 1) {
                res = res + 50;
            }else if(s.charAt(i)=='X' && s.charAt(i+1)=='L') {
                res = res + 40;
                flagL = 0;
            }else if(s.charAt(i)=='X' && flagX == 1) {
                res = res + 10;
            }else if(s.charAt(i)=='I' && s.charAt(i+1)=='X') {
                res = res + 9;
                flagX = 0;
            }else if(s.charAt(i)=='V' && flagV == 1) {
                res = res + 5;
            }else if(s.charAt(i)=='I' && s.charAt(i+1)=='V') {
                res = res + 4;
                flagV = 0;
            }else if(s.charAt(i)=='I') {
                res = res + 1;
            }
        }

        // */

        /*

        for(int i=s.length()-1; i>0; i--) {
            if(s.charAt(i)=='M' && s.charAt(i-1)!='C') {
                res = res + 1000;
            }else if(s.charAt(i)=='M' && s.charAt(i-1)=='C') {
                res = res + 900;
            }else if(s.charAt(i)=='D' && s.charAt(i-1)!='C') {
                res = res + 500;
            }else if(s.charAt(i)=='D' && s.charAt(i-1)=='C') {
                res = res + 400;
            }else if(s.charAt(i)=='C' && s.charAt(i-1)!='X') {
                res = res + 100;
            }else if(s.charAt(i)=='C' && s.charAt(i-1)=='X') {
                res = res + 90;
            }else if(s.charAt(i)=='L' && s.charAt(i-1)!='X') {
                res = res + 50;
            }else if(s.charAt(i)=='L' && s.charAt(i-1)=='X') {
                res = res + 40;
            }else if(s.charAt(i)=='X' && s.charAt(i-1)!='I') {
                res = res + 10;
            }else if(s.charAt(i)=='X' && s.charAt(i-1)=='I') {
                res = res + 9;
            }else if(s.charAt(i)=='V' && s.charAt(i-1)!='I') {
                res = res + 5;
            }else if(s.charAt(i)=='V' && s.charAt(i-1)=='I') {
                res = res + 4;
            }else if(s.charAt(i)=='I') {
                res = res + 1;
            }
        }

         */

        return res;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        int res = romanToInt(s);
        System.out.println(res);
    }

}

/*

class Solution {
    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = symbolValues.get(s.charAt(i));
            if (i < n - 1 && value < symbolValues.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/roman-to-integer/solution/luo-ma-shu-zi-zhuan-zheng-shu-by-leetcod-w55p/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

-------------------------------------
import java.util.*;

class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}

作者：donespeak
链接：https://leetcode-cn.com/problems/roman-to-integer/solution/yong-shi-9993nei-cun-9873jian-dan-jie-fa-by-donesp/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
