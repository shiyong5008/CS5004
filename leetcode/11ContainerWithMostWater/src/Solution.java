class Solution {
    public static int maxArea(int[] height) {
        int area;
        int max = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            area = Math.min(height[l], height[r]) * (r - l);
            if (area > max) {
                max = area;
            }
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        int max1 = maxArea(height1);
        System.out.println(max1);

        int[] height2 = {1,1};
        int max2 = maxArea(height2);
        System.out.println(max2);
    }
}

/*
class Solution {
    public static int maxArea(int[] height) {
        int area;
        int maxJ = 0;
        int maxI = 0;
        for(int i=0; i<height.length; i++) {
            for(int j=i; j< height.length; j++) {
                area = Math.min(height[i], height[j]) * Math.abs(j-i);
                if(area > maxJ) {
                    maxJ = area;
                }
            }
            if(maxJ > maxI) {
                maxI = maxJ;
            }
        }
        return maxI;
    }

    public static void main(String[] args) {
        int[] height1 = {1,8,6,2,5,4,8,3,7};
        int maxI1 = maxArea(height1);
        System.out.println(maxI1);

        int[] height2 = {1,1};
        int maxI2 = maxArea(height2);
        System.out.println(maxI2);

    }
}

 */