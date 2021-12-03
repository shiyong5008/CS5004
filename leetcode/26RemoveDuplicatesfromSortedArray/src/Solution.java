class Solution {
    public int removeDuplicates(int[] nums) {

        /*
        执行用时：
384 ms
, 在所有 Java 提交中击败了
5.45%
的用户
内存消耗：
39.6 MB
, 在所有 Java 提交中击败了
81.29%
的用户
*/
        /*
        int n = nums.length;
        if (n == 0 || n == 1) return n;

        for (int i = 1; i < n; ++i) {
            int x = nums[i-1];
            int j = i;
            while (j+1 < n && nums[i] <= x) {
                nums[i] = nums[j + 1];
                ++j;
            }
        }

        int k = 1;
        for (int i = 0; i < n-1; ++i) {
            if(nums[i] < nums[i+1]) ++k;
        }

        return k;

         */


        int n = nums.length;
        if (n == 0 || n == 1) return n;

        int fast = 1, slow = 1;

        while (fast < n) {
            if (nums[fast] == nums[fast - 1]) {
                ++fast;
            } else {
                nums[slow] = nums[fast];
                ++slow;
                ++fast;
            }
        }

        return slow;

    }
}
