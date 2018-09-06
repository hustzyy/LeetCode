package Number_125;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution that = new Solution();
		Scanner cin = new Scanner(System.in);
		String str = cin.nextLine(); // �����ո���ַ���
		if (that.isPalindrome(str)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		cin.close();
	}

	public boolean isPalindrome(String s) {
		s = s.toLowerCase(); // !!!�÷������ַ����еĴ�д��ĸת��ΪСд��������Ǵ�Сд��ĸ���򲻶������
		int low = 0, high = s.length() - 1;
		while (low < high) {
			if (!isValid(s.charAt(low))) {
				low++;
				continue;
			}
			if (!isValid(s.charAt(high))) {
				high--;
				continue;
			} // ͨ������һ��ѭ���ҵ�ǰ�������Ϸ��ıȽ�λ��
			if (s.charAt(low) == s.charAt(high)) {
				low++;
				high--;
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isValid(char ch) {
		int k = ch; // �;��ȸ�ֵ���߾��Ȼ��Զ���������ת��
		if ((k >= 48 && k <= 57) || (k >= 97 && k <= 122)) // ��ĿҪ��ֻ������ĸ������
			return true;
		else
			return false;
	}

}
