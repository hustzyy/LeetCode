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

	// ��һ����������һ��ɨ�裬ע����������
	public int singleNumber(int[] nums) { // ��Ŀ��ʾ��������Ԫ��,��������Ԫ�ظ���Ϊ����.�������ֻ����һ�ε�Ԫ��ֻ�������ż��λ��(�����±�)
		Arrays.sort(nums);
		int i = 0;
		while (i <= nums.length - 3) {
			if (nums[i] != nums[i + 1])
				break;
			else
				i += 2;
		}
		return nums[i];  //�������������1.whileѭ��ʱ�ҵ�break�����õ��Ľ��  2.whileѭ��û�ҵ�����ʱiָ��nums.length-1��������Ԫ�ؾ���Ŀ��ֵ
	}

	// ����������������㣬���㽻���ɺͽ���ɣ�����a^b^c^b^c==a^b^b^c^c������Ϊb^b==0������a^b^c^b^c==a
	public int singleNumber2(int[] nums) {
		int temp = 0;
		for(int i = 0; i < nums.length; i++){
			temp ^= nums[i];
		}
		return temp;
	}

}
