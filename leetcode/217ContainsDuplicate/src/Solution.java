/*

public class Solution {
    public static boolean containsDuplicate(int[] nums) {

        for(int i=0; i< nums.length; i++) {
            for(int j=i+1; j< nums.length; j++) {
                if(nums[i]==nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }
}

 */

/*
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i< nums.length-1; i++) {
            if(nums[i]==nums[i+1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums));
    }
}

 */

/*
import java.util.HashSet;

public class Solution {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> s = new HashSet<>();
        for(int i=0; i< nums.length; i++) {
            if(!s.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }
}


 */

import java.util.HashMap;

public class Solution {
    public static boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> s = new HashMap<>();
        for(int i=0; i< nums.length; i++) {
            if(!s.containsKey(nums[i])) {
                s.put(nums[i], 1);
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }
}