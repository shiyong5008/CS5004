/*

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] r = new int[2];
        int key;
        int i;
        for (i=0; i<nums.length; i++) {
            for (key=i+1; key<nums.length; key++) {
                if (nums[key] == target - nums[i]) {
                    r[0] = i;
                    r[1] = key;
                }
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 5, 7, 9};
        int target = 11;
        int r[] = new int[2];
        r = twoSum(nums, target);
        System.out.println("["+r[0]+","+r[1]+"]");
    }
}

 */

/*
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] out = new int[2];
        for(int i=0; i< nums.length; i++) {
            for(int j=i+1; j< nums.length; j++) {
                if(nums[i]+nums[j]==target) {
                    out[0]=i;
                    out[1]=j;
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 5, 7, 9};
        int target = 11;
        int r[] = new int[2];
        r = twoSum(nums, target);
        System.out.println(r);
        System.out.println("["+r[0]+","+r[1]+"]");
    }
}

 */

import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int i=0; i< nums.length; i++) {
            if(m.containsKey(target-nums[i])) {
                return new int[]{m.get(target-nums[i]), i};
            }
            m.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 5, 7, 9};
        int target = 11;
        int r[] = new int[2];
        r = twoSum(nums, target);
        System.out.println(r);
        System.out.println("["+r[0]+","+r[1]+"]");
    }
}
