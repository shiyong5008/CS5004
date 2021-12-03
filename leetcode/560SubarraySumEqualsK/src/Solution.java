class Solution {
    public int subarraySum(int[] nums, int k) {

        int cnt = 0;
        for (int i = 0; i < nums.length; ++i) {
            int pre = nums[i];
            if (pre == k) {
                ++cnt;
            }
            int j = i + 1;
            while (j < nums.length) {
                if (nums[j] + pre < k) {
                    pre = pre + nums[j];
                    ++j;
                } else if (nums[j] + pre == k) {
                    ++cnt;
                    pre = pre + nums[j];
                    ++j;
                } else {
                    pre = pre + nums[j];
                    ++j;
                }
            }
        }
        return cnt;
    }
}
