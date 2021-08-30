package leetcode.problem122;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }

    // public int maxProfit(int[] prices) {
    // int len = prices.length;
    // int i = 0; // 开始点
    // int pre = 0;
    // int sum = 0;
    // for (int j = 1; j < len; j++) { // 终止点
    // if (pre < prices[j] - prices[i]) { // 终止点-开始点的差值变大，要保存
    // pre = prices[j] - prices[i];
    // } else { // 如果差值减小或者没变
    // // System.out.println(i + "->" + (j - 1));
    // sum += pre; // 将差值加到结果中
    // pre = 0; // 差值清零
    // i = j; // 开始点变为终止点
    // }
    // }
    // return sum + pre;
    // }

    // 把所有增加的累加起来
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int sum = 0;
        for (int i = 0; i < len - 1; i++) {
            int tmp = prices[i + 1] - prices[i];
            if (tmp > 0) {
                sum += tmp;
            }
        }
        return sum;
    }
}
