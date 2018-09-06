package Number_122;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution that = new Solution();
		Scanner cin = new Scanner(System.in);
		int length = cin.nextInt();
		int[] nums = new int[length];
		for (int i = 0; i < length; i++)
			nums[i] = cin.nextInt();
		int profit = that.maxProfit(nums);
		System.out.println(profit);
		cin.close();
	}

	/* 注意题目要求最大利益，即可以进行多次交易
	 * 交易的注意点：手上没有股票才能买，有股票才能卖
	 * 买入：明天的价格比今天高，且不持有股票
	 * 卖出：在买入之后最后一个持续增长日
	 * 思路: 连续增长的一段时间的利润可以分段累加，例如a->b->c，a天买c天卖的利润为c-a，等价于(b-a)+(c-b),
	 * 		  所以就可以先把每过一天的利润先累加。
	 * 该思路相当于转化成求最大子序列和
	 * */
	public int maxProfit(int[] prices) {
		int profit = 0, i = 0;
		while (i < prices.length - 1) {
			if (prices[i + 1] > prices[i]) { //i顺序往后扫描，加上此条件保证了卖出之前肯定持有，那么产生的利润即有效利润
				profit += prices[i + 1] - prices[i]; //分段累加
			}
			++i;
		}
		return profit;
	}
}
