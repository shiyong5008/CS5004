import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int prod = 1;

        // HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> map = new ArrayList<>();
        int[] out = new int[n];

        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                map.add(i);
            } else {
                prod = prod * nums[i];
            }
        }

        for (int i = 0; i < n; ++i) {
            if (map.size() == 0) {
                out[i] = prod / nums[i];
            } else if (map.size() == 1) {
                if (nums[i] == 0) {
                    out[i] = prod;
                } else {
                    nums[i] = 0;
                }
            } else {
                nums[i] = 0;
            }
        }
        return out;
    }
}
