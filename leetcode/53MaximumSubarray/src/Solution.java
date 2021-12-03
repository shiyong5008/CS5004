
/*
// greedy or dp:
class Solution {
    public static int maxSubArray(int[] nums) {
        int pre = 0;
        int max = nums[0];
        for(int x : nums) {
            pre = Math.max(pre+x, x);
            max = Math.max(pre, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int max = maxSubArray(nums);
        System.out.println(max);
    }
}

 */


/*
53. 最大子序和（暴力求解）
class Solution {
    public int maxSubArray(int[] nums) {
      int max = nums[0];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }
}

作者：shu-liao-jiu-gai-ren
链接：https://leetcode-cn.com/problems/maximum-subarray/solution/53-zui-da-zi-xu-he-bao-li-qiu-jie-by-shu-ty9k/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

class Solution {
    public static int maxSubArray(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        result find = divide(nums, low, high);
        return find.sum;
    }

    public static class result {
        int low;
        int high;
        int sum;

        public result(int low, int high, int sum) {
            this.low = low;
            this.high = high;
            this.sum = sum;
        }
    }

    public static result cross(int[] nums, int low, int mid, int high) {
        int leftSum = 0;
        int leftMaxSum = Integer.MIN_VALUE;
        int leftLow = mid;
        for(int i=mid; i>=low; i--) {
            leftSum += nums[i];
            if(leftSum > leftMaxSum) {
                leftMaxSum = leftSum;
                leftLow = i;
            }
        }
        int rightSum = 0;
        int rightMaxSum = Integer.MIN_VALUE;
        int rightHigh = mid+1;
        for(int j=mid+1; j<=high; j++) {
            rightSum += nums[j];
            if(rightSum > rightMaxSum) {
                rightMaxSum = rightSum;
                rightHigh = j;
            }
        }
        // System.out.println(leftMaxSum+rightMaxSum + "midcross");
        return new result(leftLow, rightHigh, leftMaxSum+rightMaxSum);
    }

    public static result divide(int[] nums, int low, int high) {
        if(low == high) {
            return new result(low, high, nums[low]);
        }else {
            int mid = (low + high)/2;
            result left = divide(nums, low, mid);
            result right = divide(nums, mid+1, high);
            result cross = cross(nums, low, mid, high);

            if(left.sum>=right.sum && left.sum>=cross.sum) {
                // System.out.println(left.sum+"left");
                return left;
            }else if(right.sum>=left.sum && right.sum>=cross.sum) {
                // System.out.println(right.sum+"right");
                return right;
            }else {
                // System.out.println(cross.sum+"cross");
                return cross;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {-1,-1,-2,-2};
        int max = maxSubArray(nums);
        System.out.println(max);
    }
}
