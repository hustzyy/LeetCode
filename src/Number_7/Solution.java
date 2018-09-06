package Number_7;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution that = new Solution();
		Scanner cin = new Scanner(System.in);
		int x = cin.nextInt();
		x = that.reverse3(x);
		System.out.println(x);
		cin.close();
	}

	// ��һ��ʹ��java���������ַ������ַ����顢����֮��ת��
	public int reverse(int x) {
		char[] ch = String.valueOf(x).toCharArray();
		int low, high = ch.length - 1;
		char temp;
		if (ch[0] - '0' >= 0) { // �ж��Ƿ��и��ţ�����һ�㶼��ʡ��
			low = 0;
		} else {
			low = 1;
		}
		while (low < high) {
			temp = ch[low];
			ch[low++] = ch[high];
			ch[high--] = temp;
		}
		// Integer.parseInt()�������ַ���������Ϊ�з��ŵ�ʮ�����������н�������Χ����
		// ���˵�һ���ַ�������������ʾ��ֵ�� ASCII ���� '-' �⣬�ַ����е��ַ���������ʮ�������֡�
		// ����Ҫ��ֹ��ת�������ֵ�����
		try {
			return Integer.parseInt(String.valueOf(ch));
		} catch (Exception e) {
			return 0;
		}
	}

	// ����
	public int reverse2(int x) {
		long input = x > 0 ? x : -1 * x; // 1.�����ֵ 2.long��int���ȸߣ�����Ҫǿת
		long result = 0;
		while (input > 0) {
			result = result * 10 + input % 10;
			input /= 10;
		}
		if (x < 0) {
			result *= -1;
			if (result < Integer.MIN_VALUE) // ����
				return 0;
		} else {
			if (result > Integer.MAX_VALUE) // ����
				return 0;
		}
		return Long.valueOf(result).intValue();
	}

	//�����򻯰�
	public int reverse3(int x) {
		long input = x;
		long result = 0;
		while (input != 0) {
			result = result * 10 + input % 10;
			input /= 10;
		}
		if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
			return 0;
		else
			return (int) result;
	}

}
