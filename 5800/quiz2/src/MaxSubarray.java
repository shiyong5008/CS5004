
public class MaxSubarray {

    //内部类，用来存储最大子数组的返回结果，
    private static class Result {
        int low;
        int high;
        int sum;

        public Result(int low, int high, int sum) {
            this.low = low;
            this.high = high;
            this.sum = sum;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "low=" + low +
                    ", high=" + high +
                    ", sum=" + sum +
                    '}';
        }
    }

    private static Result FindMaxCrossSubarray(int[]A,int low, int mid, int high){

        //寻找左边的连续最大值及记录位置
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = mid;
        for (int i=mid; i>=low; i--){
            sum = sum + A[i];
            if(sum > leftSum){
                leftSum = sum;
                maxLeft = i;
            }
        }

        //寻找右边的连续最大值及记录位置
        int rightSum = Integer.MIN_VALUE;
        int maxRight = mid+1;
        sum = 0;
        for ( int j=mid+1; j<=high;j++){
            sum = sum + A[j];
            if(sum > rightSum){
                rightSum = sum;
                maxRight = j;
            }
        }

        //返回跨越中间值的最大子数组结果
        return new Result(maxLeft,maxRight,leftSum + rightSum);
    }


    public static  Result FindMaxSubarray(int[] A, int low, int high){
        //数组只有一个元素时的处理情况
        if (high == low){
            return new Result(low,high,A[low]);
        }else {
            //对应思路中步骤1，找到中间元素
            int mid = (low + high)/2;
            //对应思路中步骤2，分别对应a,b,c三种情况求解最大子数组结果
            Result leftResult = FindMaxSubarray(A,low,mid);
            Result rightResult = FindMaxSubarray(A,mid+1,high);
            Result crossResult = FindMaxCrossSubarray(A,low,mid,high);
            //对应步骤3，比较
            if(leftResult.sum >= rightResult.sum && leftResult.sum >= crossResult.sum){
                return leftResult;
            }else if (rightResult.sum >= leftResult.sum && rightResult.sum >= crossResult.sum){
                return rightResult;
            }else {
                return crossResult;
            }
        }
    }

    public static void main(String[] args){
        int[] A = {-1, 1, 3, -5, 7, 9, -11, 13, 15, -17, 19, 21, -23};
        System.out.println(FindMaxSubarray(A,0,A.length-1).toString());
    }
}

