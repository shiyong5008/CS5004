class Solution {
    public int[] searchRange(int[] nums, int target) {

        // use 5 7 7 8 8 10 target = 8 and 6 to practice.
        // key point is when target = mid, need move left or right.
        // and when target = mid, want to move left, need use mid = (start + end + 1) / 2.

        int n = nums.length;
        if (n == 0) return new int[] {-1,-1};

        int left = 0, right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int start = 0, end = n - 1;
        while (start < end) {
            int mid = (start + end + 1) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                start = mid;
            }
        }

        if (nums[left] == target && nums[start] == target) {
            return new int[] {left, start};
        } else {
            return new int[] {-1, -1};
        }

    }
}
