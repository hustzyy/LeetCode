package Number_283;

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
		that.moveZeroes2(nums);
		System.out.println(Arrays.toString(nums));
		cin.close();
	}

	// ��һ���ռ任ʱ��
	public void moveZeroes(int[] nums) {
		int[] result = new int[nums.length];
		int i = 0, j = 0;
		for (; i < nums.length; i++) {
			if (nums[i] != 0) {
				result[j++] = nums[i];
			}
		}
		for (i = 0; i < nums.length; i++) {
			nums[i] = result[i];
		}
	}

	//������ԭ�ؽ��������飬newlenΪ������ĳ���
	public void moveZeroes2(int[] nums) {
		int newlen = 0, i = 0;
		for (; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[newlen++] = nums[i];
			}
		}
		for (i = newlen; i < nums.length; i++) {
			nums[i] = 0;
		}
	}

}
