import java.util.ArrayList;
import java.util.List;

class Solution {

    List<List<Integer>> lists = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        int n = nums.length;
        boolean[] used = new boolean[n];
        helper(0, n, nums, used);
        return lists;

    }

    private void helper(int depth, int n, int[] nums, boolean[] used) {

        if (list.size() == n) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < n; ++i) {
            if (used[i]) {
                continue;
            }

            list.add(nums[i]);
            used[i] = true;
            helper(depth+1, n, nums, used);
            list.remove(list.size()-1);
            used[i] = false;
        }

    }
}
