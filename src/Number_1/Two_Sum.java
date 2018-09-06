package Number_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Two_Sum {
	// 默认有且只有一组解
	public static void main(String[] args) {
		Two_Sum that = new Two_Sum();
		Scanner cin = new Scanner(System.in);
		int length, target;
		length = cin.nextInt();
		target = cin.nextInt();
		int[] nums = new int[length];
		for (int i = 0; i < length; i++)
			nums[i] = cin.nextInt();
		int[] result = that.twoSum2(nums, target);
		System.out.println(result[0] + " " + result[1]);
		cin.close();
	}

	// 暴力求解，时间复杂度O(n^2)
	private int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++)
			for (int j = i + 1; j < nums.length; j++)
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j };
				}
		throw new IllegalArgumentException("No two sum solution");
	}

	// 利用空间换时间，使用HashMap,时间复杂度O(n)
	private int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; ++i) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
