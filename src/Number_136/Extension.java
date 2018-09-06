package Number_136;

import java.util.Arrays;
import java.util.Scanner;

//题目改为只有一个数出现两次，其余每个元素出现一次
public class Extension {

	public static void main(String[] args) {
		Extension that = new Extension();
		Scanner cin = new Scanner(System.in);
		int length = cin.nextInt();
		int[] nums = new int[length];
		for (int i = 0; i < length; i++)
			nums[i] = cin.nextInt();
		int dn = that.doubleNumber(nums);
		System.out.println(dn);
		cin.close();
	}

	// 法一：先排序，该数组无特性
	public int doubleNumber(int[] nums) {
		Arrays.sort(nums);
		int i = 0;
		for (; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1])
				break;
		}
		return nums[i];
	}

	//法二：异或运算  (a^b^c^c^d) == a^b^d    //想法有问题，这题用不了异或运算
	public int doubleNumber2(int[] nums) {
		
		return 0;
	}

}

// 测试用例：
// 5      1 2 3 3 4          3
// 6     -1 6 0 4 -1 5      -1
// 7      9 12 4 8 0 1 4     4
// 7      2 2 3 4 5 6 7      2
// 6      1 2 3 4 5 6 6      6