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

	// ��һ��ʹ�ü��ϣ����������������Ƿ����Ŀ��ֵ
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

	// �������������ٲ���
	public boolean containsDuplicate2(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; i++) { //��֤������������������Ԫ��ʱ�ſ�ʼ�Ƚ�
			if(nums[i] == nums[i + 1])
				return true;
		}
		return false;
	}

}
