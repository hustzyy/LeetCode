package Number_189;

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
		int k = cin.nextInt(); // �������������ƶ���λ��
		that.rotate(nums, k);
		System.out.println(Arrays.toString(nums)); // ������numsת��Ϊ�ַ���
		// System.out.println(nums.toString()); //���ַ�������ʽ��������nums���׵�ַ
		cin.close();
	}

	public void rotate(int[] nums, int k) {
		int newk = k % nums.length;     //����λ�����������鱾���ȣ���ʱ��ͬ�����鱾���ȵ�λ��������Ч�ģ�����ȡ����
		if (newk == 0 || nums.length == 1) //���λ�����ǳ��ȵı����������鲻�䣻������鳤����1������λ�ƶ��ٲ������䣻���Ұ����鳤��Ϊ1�������ֹ������ú�����������Խ�硣
			return;
		reverse(nums, nums.length - newk, nums.length - 1);
		reverse(nums, 0, nums.length - newk - 1);
		reverse(nums, 0, nums.length - 1);
	}

	public void reverse(int arry[], int low, int high) {
		int temp;
		while (low < high) {
			temp = arry[low];
			arry[low++] = arry[high];
			arry[high--] = temp;
		}
	}
	
}
