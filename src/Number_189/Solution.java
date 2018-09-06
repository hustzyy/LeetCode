package Number_189;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution that = new Solution();
		Scanner cin = new Scanner(System.in);
		int length = cin.nextInt();
		int[] nums = new int[length];
		for (int i = 0; i < length; i++)
			nums[i] = cin.nextInt();
		int k = cin.nextInt(); // 键盘输入向右移动的位数
		that.rotate(nums, k);
		System.out.println(Arrays.toString(nums)); // 将数组nums转化为字符串
		// System.out.println(nums.toString()); //以字符串的形式返回数组nums的首地址
		cin.close();
	}

	public void rotate(int[] nums, int k) {
		int newk = k % nums.length;     //考虑位移数大于数组本身长度，此时等同于数组本身长度的位移数是无效的，所以取余数
		if (newk == 0 || nums.length == 1) //如果位移数是长度的倍数，则数组不变；如果数组长度是1，不管位移多少步都不变；而且把数组长度为1拎出来防止下面调用函数出现数组越界。
			return;
		reverse(nums, nums.length - newk, nums.length - 1);
		reverse(nums, 0, nums.length - newk - 1);
		reverse(nums, 0, nums.length - 1);
	}

	public void reverse(int arry[], int low, int high) {
		int temp;
		while (low < high) {
			temp = arry[low];
			arry[low++] = arry[high];
			arry[high--] = temp;
		}
	}
	
}
