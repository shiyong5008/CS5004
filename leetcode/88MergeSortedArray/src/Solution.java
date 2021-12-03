/*

import java.util.Arrays;

class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0; i<n; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

}

 */



import java.util.Arrays;

class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int tail = m+n-1;
        int cur;
        while(p1>=0 || p2>=0) {
            if(p1 == -1) {
                cur = nums2[p2];
                p2--;
            }else if(p2 == -1) {
                cur = nums1[p1];
                p1--;
            }else if(nums1[p1] < nums2[p2]) {
                cur = nums2[p2];
                p2--;
            }else {
                cur = nums1[p1];
                p1--;
            }
            nums1[tail] = cur;
            tail--;
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

}
