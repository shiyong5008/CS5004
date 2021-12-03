class Solution {
    String[] thousands = {"", "M", "MM", "MMM"};
    String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();
    }
}

/*
作者：LeetCode-Solution
        链接：https://leetcode-cn.com/problems/integer-to-roman/solution/zheng-shu-zhuan-luo-ma-shu-zi-by-leetcod-75rs/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */


/*
class Solution {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }
}

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/integer-to-roman/solution/zheng-shu-zhuan-luo-ma-shu-zi-by-leetcod-75rs/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

/*
class Solution {
    public String intToRoman(int num) {
        if(num <= 0){
            return null;
        }
        StringBuilder res = new StringBuilder();
        while(num > 0){
            if(num >= 1000){
                res.append("M");
                num = num - 1000;
            } else if (num >= 900) {
                res.append("CM");
                num = num - 900;
            } else if (num >= 500){
                res.append("D");
                num = num - 500;
            } else if (num >= 400){
                res.append("CD");
                num = num - 400;
            } else if (num >= 100){
                res.append("C");
                num = num - 100;
            } else if (num >= 90){
                res.append("XC");
                num = num - 90;
            } else if (num >= 50){
                res.append("L");
                num = num - 50;
            } else if (num >= 40){
                res.append("XL");
                num = num - 40;
            } else if (num >= 10){
                res.append("X");
                num = num -10;
            } else if (num >= 9){
                res.append("IX");
                num = num - 9;
            } else if (num >= 5){
                res.append("V");
                num = num - 5;
            } else if (num >= 4){
                res.append("IV");
                num = num - 4;
            } else {
                res.append("I");
                num = num - 1;
            }
        }
        return res.toString();
    }
}

作者：shao-6t
链接：https://leetcode-cn.com/problems/integer-to-roman/solution/javaji-bai-100kan-bu-dong-ni-da-wo-by-sh-1lot/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */