import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {

        /*
        int n = nums.length;
        if (n == 0) return n;
        int slow = 0, fast = 0;

        Arrays.sort(nums);

        int flag = 1;
        for (int i = 0; i < n; ++i) {
            if (flag == 1 && nums[fast] != val) {
                ++fast;
                ++slow;
            }
            if (fast < n && nums[fast] == val) {
                flag = 0;
                ++fast;
            }
        }

        while (fast < n) {
            nums[slow] = nums[fast];
            ++fast;
            ++slow;
        }
        return slow;

         */

        int left = 0;
        int right = nums.length -1;

        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                --right;
            } else ++left;
        }
        return left;

    }
}
