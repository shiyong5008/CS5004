class Solution {
    public int searchInsert(int[] nums, int target) {

        /* fail
        int n = nums.length;
        if (n == 0) return 0;
        return helper(nums, target, 0, n-1);

    }

    public int helper(int[] nums, int target, int left, int right) {

        int n = right - left;
        int mid = n/2 + left;
        if (left == right) return mid;

        if (target == nums[mid]) return mid;
        else if (target < nums[mid]) return helper(nums, target, left, mid);
        else return helper(nums, target, mid+1, right);

         */

        int n = nums.length;
        int left = 0, right = n-1;
        int ans = n;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else left = mid + 1;
        }
        return ans;

    }
}
