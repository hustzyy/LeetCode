package Number_66;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution that = new Solution();
		Scanner cin = new Scanner(System.in);
		int len = cin.nextInt();
		int[] nums = new int[len];
		for (int i = 0; i < len; i++)
			nums[i] = cin.nextInt();
		System.out.println(Arrays.toString(that.plusOne(nums)));
		cin.close();
	}

	public int[] plusOne(int[] digits) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int temp = 0, flag = 1, i;
		for (i = digits.length - 1; i >= 0; i--) { // 从低位往高位读取，即数组从后往前扫描
			temp = digits[i] + flag;
			flag = temp / 10; // 进位
			list.add(temp % 10); // 低位
		}
		if (flag == 1) {
			list.add(1);
		}
		flag = list.size();
		int[] nums = new int[flag];
		for (i = 0; i < flag; i++) { // 集合中顺序存的该数从低位到高位上的值，所以要反过来
			nums[flag - 1 - i] = list.get(i);
		}
		return nums;
	}

}
