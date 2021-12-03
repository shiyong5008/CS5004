/*

class Solution {
    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i=0; i< prices.length-1; i++) {
            for (int j=i+1; j< prices.length; j++) {
                int temp = prices[j] - prices[i];
                if (max < temp) {
                    max = temp;
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] in = new int[] {7,1,5,3,6,4};
        int max = maxProfit(in);
        System.out.println(max);
    }

}

 */

/*
class Solution {
    public static int maxProfit(int[] prices) {

        int minPric = Integer.MAX_VALUE;
        int maxProf = 0;
        for (int price : prices) {
            if (price < minPric) {
                minPric = price;
            } else if (price - minPric > maxProf) {
                maxProf = price - minPric;
            }
        }
        return maxProf;
    }

    public static void main(String[] args) {
        int[] in = new int[] {7,1,5,3,6,4};
        int max = maxProfit(in);
        System.out.println(max);
    }

}

 */

/*
class Solution {
    public static int maxProfit(int[] prices) {

        int i = 0; // slower ptr.
        int j = 1; // fast ptr.
        int maxProf = 0;
        // int minPric = Integer.MAX_VALUE;
        while (j < prices.length) {
            if (prices[j] < prices[i]) {
                i = j;
            } else if (prices[j] - prices[i] > maxProf) {
                maxProf = prices[j] - prices[i];
            }
            j++;
        }
        return maxProf;
    }

    public static void main(String[] args) {
        int[] in = new int[] {7,1,5,3,6,4};
        int max = maxProfit(in);
        System.out.println(max);
    }

}

 */



class Solution {
    public static int maxProfit(int[] prices) {
        //首先定义最低价格和最大利润两个变量
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1;i < prices.length;i++){
            //将最低价格和当前价格比较，低的为新的最低价格
            minPrice = Math.min(prices[i],minPrice);
            //将当前价格减去最低价格的值与最大利润比较，高的为新的最大利润
            maxProfit = Math.max(prices[i] - minPrice,maxProfit);
        }
        //返回最大利润
        return maxProfit;

        /*
        作者：lan-ch
        链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/121-mai-mai-gu-piao-de-zui-jia-shi-ji-ta-5xfw/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

         */
    }

    public static void main(String[] args) {
        int[] in = new int[] {7,1,5,3,6,4};
        int max = maxProfit(in);
        System.out.println(max);
    }

}

