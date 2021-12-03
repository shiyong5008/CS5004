class Solution {
    public boolean increasingTriplet(int[] nums) {

        int n = nums.length;
        if (n < 3) return false;

        /*
        for (int i = 0; i < n - 2; ++i) {
            for (int j = i + 1; j < n - 1; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if (nums[i] < nums[j] && nums[j] < nums[k]) {
                        return true;
                    }

                }
            }
        }
        return false;

         */

        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;

        for (int x : nums) {
            if (x < min) min = x;
            else if (x > min && x < mid) mid = x;
            else if (x > mid) return true;
        }
        return false;
    }
}
