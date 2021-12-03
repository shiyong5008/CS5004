/*

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0;
        int p2 = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        HashMap<Integer, Integer> m = new HashMap<>();
        int k = 0;

        if (n1 == 0) {
            return nums1;
        } else if(n2 == 0) {
            return nums2;
        }
        while (p1<n1 && p2<n2) {
            if(nums1[p1] < nums2[p2]) {
                p1++;
            } else if(nums1[p1] > nums2[p2]) {
                p2++;
            } else if(nums1[p1] == nums2[p2]) {
                m.put(k, nums1[p1]);
                k++;
                p1++;
                p2++;
            }
        }

        int[] inter = new int[k];
        for (int i=0; i<k; i++) {
            inter[i] = m.get(i);
        }
        return inter;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2,2};
        int[] inter = intersect(nums1, nums2);
        System.out.println(Arrays.toString(inter));
    }

}

 */


import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {

        if (nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }

        HashMap<Integer, Integer> m = new HashMap<>();

        for (int num: nums1) {
            int count = m.getOrDefault(num, 0) + 1;
            m.put(num, count);
        }

        int[] inter = new int[nums1.length];
        int k = 0;

        for (int num: nums2) {
            int count = m.getOrDefault(num, 0);
            if (count > 0) {
                inter[k] = num;
                k++;
                count--;
                if (count > 0) {
                    m.put(num, count);
                } else {
                    m.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(inter, 0, k);

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2,2};
        int[] inter = intersect(nums1, nums2);
        System.out.println(Arrays.toString(inter));
    }

}
