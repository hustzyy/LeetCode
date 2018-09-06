package Number_136;

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
		int single = that.singleNumber(nums);
		System.out.println(single);
		cin.close();
	}

	// 法一：先排序，再一趟扫描，注意数组特性
	public int singleNumber(int[] nums) { // 题目暗示至少三个元素,且数组总元素个数为奇数.所以这个只出现一次的元素只会出现在偶数位上(数组下标)
		Arrays.sort(nums);
		int i = 0;
		while (i <= nums.length - 3) {
			if (nums[i] != nums[i + 1])
				break;
			else
				i += 2;
		}
		return nums[i];  //包括两种情况：1.while循环时找到break跳出得到的结果  2.while循环没找到，此时i指向nums.length-1，最后这个元素就是目标值
	}

	// 法二：巧用异或运算，满足交换律和结合律，所以a^b^c^b^c==a^b^b^c^c，又因为b^b==0，所以a^b^c^b^c==a
	public int singleNumber2(int[] nums) {
		int temp = 0;
		for(int i = 0; i < nums.length; i++){
			temp ^= nums[i];
		}
		return temp;
	}

}
