class Solution {
    public int singleNumber(int[] nums) {

        int y = nums[0];
        for (int i = 1; i < nums.length; i++) {
            y = nums[i] ^ y;
        }
        return y;
    }
}
