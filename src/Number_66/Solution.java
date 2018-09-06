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
		for (i = digits.length - 1; i >= 0; i--) { // �ӵ�λ����λ��ȡ��������Ӻ���ǰɨ��
			temp = digits[i] + flag;
			flag = temp / 10; // ��λ
			list.add(temp % 10); // ��λ
		}
		if (flag == 1) {
			list.add(1);
		}
		flag = list.size();
		int[] nums = new int[flag];
		for (i = 0; i < flag; i++) { // ������˳���ĸ����ӵ�λ����λ�ϵ�ֵ������Ҫ������
			nums[flag - 1 - i] = list.get(i);
		}
		return nums;
	}

}
