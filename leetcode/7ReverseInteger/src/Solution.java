class Solution {
    /*
    public static int reverse(int x) {
        String y = x + "";
        String z = "";
        int len = y.length();
        if(y.charAt(0)=='-') {
            z = z + "-";
        }
        for(int i=len-1; i>=0; i--) {
            if(y.charAt(i)=='-') {
                z = z+ "";
            }else {
                z = z + y.charAt(i);
            }
        }
        if (Integer.parseInt(z) < Integer.MIN_VALUE / 10 || Integer.parseInt(z) > Integer.MAX_VALUE / 10) {
            return 0;
        }
        return Integer.parseInt(z);
    }

     */

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-1230));
    }

}
