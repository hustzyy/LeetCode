package Number_217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution that = new Solution();
		Scanner cin = new Scanner(System.in);
		int length = cin.nextInt();
		int[] nums = new int[length];
		for (int i = 0; i < length; i++)
			nums[i] = cin.nextInt();
		boolean ack = that.containsDuplicate(nums);
		if (ack) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		cin.close();
	}

	// 法一：使用集合，快速搜索集合中是否存在目标值
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				return true;
			}
			set.add(nums[i]);
		}
		return false;
	}

	// 法二：先排序，再查重
	public boolean containsDuplicate2(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) { //保证了数组中至少有两个元素时才开始比较
			if(nums[i] == nums[i + 1])
				return true;
		}
		return false;
	}

}
