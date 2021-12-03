class Solution {
    public void sortColors(int[] nums) {

        int n = nums.length;
        int i = 0;
        int j = n-1;

        while (i < j) {
            while (i<j && nums[i] == 0) {
                i++;
            }
            if (nums[j] == 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j--;
                while (i<n && nums[i] == 0) {
                    i++;
                }
            } else {
                j--;
            }
        }

        j = n-1;
        while (i < j) {
            while (i<j && nums[i] == 1) {
                i++;
            }
            if (nums[j] == 1) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j--;
                while (i<n && nums[i] == 1) {
                    i++;
                }
            } else {
                j--;
            }
        }
    }
}
