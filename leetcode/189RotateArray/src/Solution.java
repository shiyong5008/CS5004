class Solution {
    public void rotate(int[] nums, int k) {

        /*
        // over time
        int n = nums.length;;
        for (int i = 0; i < k; ++i) {
            for (int j = 0; j < n; ++j) {
                int temp = nums[j];
                nums[j] = nums[n-1];
                nums[n-1] = temp;
            }
        }

         */

        int n = nums.length;
        int m = k % n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, m-1);
        reverse(nums, m, n-1);

    }

    public void reverse(int[] nums, int l, int r) {

        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            ++l;
            --r;
        }

    }
}
