public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        /* fail
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            res = res << 1;
            if (n%2 == 1) {
                res = res + 1;
            } else {
                res = res + 0;
            }
            n = n >>> 1;
        }

        return res;

         */



        int res = 0;
        for (int i = 0; i < 32; ++i) {
            res = res << 1;
            res = res | (n & 1);  // n & 1 = n % 2
            n = n >>> 1;
        }
        return res;


    }
}
