class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int n = numbers.length;
        int left = 0, right = n - 1;

        while (true) {
            int sum = numbers[left] + numbers[right];
            if (sum < target) ++left;
            else if (sum > target) --right;
            else return new int[]{left + 1, right + 1};
        }

    }
}
