class Solution {
    public int findMin(int[] nums) {

/*
        int n = nums.length;
        int left = 0, right = n-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[left] <= nums[mid] && nums[mid] <= nums[right]) {
                return nums[left];
            }
            if (nums[right] < nums[left] && nums[left] <= nums[mid]) {
                left = mid + 1;
            }
            if (nums[mid] < nums[right] && nums[right] < nums[left]) {
                right = mid;
            }
        }
        return 0;

 */

        int n = nums.length;
        int left = 0, right = n-1;
        while (left < right) {
            int mid = (left + right)/2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];

    }
}
