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

	/* ע����ĿҪ��������棬�����Խ��ж�ν���
	 * ���׵�ע��㣺����û�й�Ʊ�������й�Ʊ������
	 * ���룺����ļ۸�Ƚ���ߣ��Ҳ����й�Ʊ
	 * ������������֮�����һ������������
	 * ˼·: ����������һ��ʱ���������Էֶ��ۼӣ�����a->b->c��a����c����������Ϊc-a���ȼ���(b-a)+(c-b),
	 * 		  ���ԾͿ����Ȱ�ÿ��һ����������ۼӡ�
	 * ��˼·�൱��ת��������������к�
	 * */
	public int maxProfit(int[] prices) {
		int profit = 0, i = 0;
		while (i < prices.length - 1) {
			if (prices[i + 1] > prices[i]) { //i˳������ɨ�裬���ϴ�������֤������֮ǰ�϶����У���ô������������Ч����
				profit += prices[i + 1] - prices[i]; //�ֶ��ۼ�
			}
			++i;
		}
		return profit;
	}
}
