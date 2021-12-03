class Solution {
    public int majorityElement(int[] nums) {

        int k = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == k) {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    k = nums[i];
                    cnt++;
                }
            }
        }
        return k;
    }
}