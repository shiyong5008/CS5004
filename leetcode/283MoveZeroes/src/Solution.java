class Solution {
    public void moveZeroes(int[] nums) {

        /* self
        int n = nums.length;
        int i = 0;

            while (i < n && nums[i] != 0) {
                ++i;
            }

            int j = i;
            while (j < n) {
                while (j < n && nums[j] == 0) {
                    ++j;
                }
                if (j < n) {
                    nums[i] = nums[j];
                    ++i;
                    ++j;
                }
            }

            for (int k = i; k < n; ++k) {
                nums[k] = 0;
            }

         */

        /* guan
        int n = nums.length;
        int i = 0, j = 0;

        while (j < n) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                ++i;
            }
            ++j;
        }

         */

        // improve
        int n = nums.length;
        int i = 0, j = 0;

        while (j < n) {
            if (nums[j] != 0) {
                nums[i] = nums[j];
                ++i;
            }
            ++j;
        }

        for (; i < n; ++i) {
            nums[i] = 0;
        }

    }
}
