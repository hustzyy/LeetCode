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

	/*��ĿҪ��ԭ��ɾ��
	 *˼·��ʹ������ָ�룬iָ������������һ��Ԫ�أ�jָ��ɨ������飬�ҳ����ظ���Ԫ�ز�����������
	 *ע�⣺Ԫ�ؽ���������ʱָ��i������ƶ������ռ�(++i)��j��ȡֵ������ƶ�(j++)
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
