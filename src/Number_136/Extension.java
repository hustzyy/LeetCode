package Number_136;

import java.util.Arrays;
import java.util.Scanner;

//��Ŀ��Ϊֻ��һ�����������Σ�����ÿ��Ԫ�س���һ��
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

	// ��һ�������򣬸�����������
	public int doubleNumber(int[] nums) {
		Arrays.sort(nums);
		int i = 0;
		for (; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1])
				break;
		}
		return nums[i];
	}

	//�������������  (a^b^c^c^d) == a^b^d    //�뷨�����⣬�����ò����������
	public int doubleNumber2(int[] nums) {
		
		return 0;
	}

}

// ����������
// 5      1 2 3 3 4          3
// 6     -1 6 0 4 -1 5      -1
// 7      9 12 4 8 0 1 4     4
// 7      2 2 3 4 5 6 7      2
// 6      1 2 3 4 5 6 6      6