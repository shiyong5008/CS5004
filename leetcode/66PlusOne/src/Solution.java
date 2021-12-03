class Solution {
    public int[] plusOne(int[] digits) {

        /* fail
        int n = digits.length;
        if (n == 1 && digits[0] == 0) {
            digits[0] = 1;
            return digits;
        }

        int sum = 0;
        int m = 0;
        for (int x : digits) {
            sum = sum + x;
        }
        if (sum == n * 9) {
            m = n + 1;
        } else m = n;

        int[] ans = new int[m];
        int up = 0;

        ans[m-1] = (digits[n-1] + 1) % 10;
        up = (digits[n-1] + 1) / 10;
        int j = n-2;
        int i;
        for (i = m - 2; i > 0; --i) {
            ans[i] = (digits[j] + up) % 10;
            up = (digits[j] + up) / 10;
            --j;
        }
        if (j == -1 && i == 0) {
            ans[0] = 1;
        } else ans[0] = digits[0] + up;

        return ans;

         */

        int n = digits.length;
        for (int i = n-1; i >= 0; --i) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                for (int j = i + 1; j < n; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }

        int[] ans = new int[n+1];
        ans[0] = 1;
        return ans;

    }
}
