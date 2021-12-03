import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {

        /*
        // O(nlogn) sorting need time; O(logn) sorting need space.
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int temp = nums[i];
            nums[i] = temp * temp;
        }
        Arrays.sort(nums);
        return nums;

         */

        // O(n) and O(1)
        int n = nums.length;
        int l = 0, r = n - 1;
        int[] ans = new int[n];
        for(int k = n-1; k >= 0; --k) {
            int x = nums[l] * nums[l];
            int y = nums[r] * nums[r];
            if (x >= y) {
                ans[k] = x;
                ++l;
            } else {
                ans[k] = y;
                --r;
            }
        }
        return ans;

    }
}
