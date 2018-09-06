package Number_26;

import java.util.Scanner;

public class Array1 {

	public static void main(String[] args) {
		Array1 that = new Array1();
		Scanner cin = new Scanner(System.in);
		int length = cin.nextInt();
		int[] nums = new int[length];
		for (int i = 0; i < length; i++)
			nums[i] = cin.nextInt();
		int newl = that.removeDuplicates(nums);
		for (int j = 0; j < newl; j++)
			System.out.print(nums[j] + " ");
		cin.close();
	}

	/*题目要求原地删除
	 *思路：使用两个指针，i指向新数组的最后一个元素，j指针扫描旧数组，找出非重复的元素并放入新数组
	 *注意：元素进入新数组时指针i先向后移动给出空间(++i)，j先取值再向后移动(j++)
	 * */
	public int removeDuplicates(int[] nums) {
		int i = 0, j = 1;
		while (j < nums.length) {
			if (nums[i] != nums[j]) {
				nums[++i] = nums[j++];
			} else {
				++j;
			}
		}
		return i + 1;
	}
}
