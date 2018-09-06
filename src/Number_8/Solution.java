package Number_8;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution that = new Solution();
		Scanner cin = new Scanner(System.in);
		String str = cin.nextLine(); // �����ո���ַ���
		System.out.println(that.myAtoi(str));
		cin.close();
	}

	public int myAtoi(String str) {
		int sign = 1, index = 0;
		long result = 0;
		while (index < str.length() && str.charAt(index) == ' ')// ָ��ָ����һ���ǿո��ַ�����δ�ҵ��ǿո��ַ�
			++index;
		if (index < str.length() && str.charAt(index) == '-') {// ��ֹ����Խ��
			sign = -1;
			++index;
		} else if (index < str.length() && str.charAt(index) == '+') {
			++index;
		}
		while (index < str.length() && Character.isDigit(str.charAt(index))) {
			result = result * 10 + (str.charAt(index) - '0');
			if (result > Integer.MAX_VALUE) {// ���ڵ��ڱ߽綼��ȡ�߽�
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE; // ���������ж϶��������������Ϊ��ֹ����ۼӳ���long�ķ�Χ
			}
			++index;
		}
		return (int) result * sign;
	}

}
