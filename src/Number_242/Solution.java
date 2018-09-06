package Number_242;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution that = new Solution();
		Scanner cin = new Scanner(System.in);
		String s = cin.next();
		String t = cin.next(); // next()���������Զ�ȡ�ո�,�ո񼴷ָ���
		boolean flag = that.isAnagram(s, t);
		if (flag) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		cin.close();
	}

	// ��һ���ռ任ʱ��(������)
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		long[] book = new long[26]; // �������ڣ���������ַ����ܳ���������ͳ��ĳһ���ַ����ִ���ʱ������������int������long
		int i;
		for (i = 0; i < s.length(); ++i) {
			++book[s.charAt(i) - 'a'];
			--book[t.charAt(i) - 'a'];
		}
		for (i = 0; i < 26; ++i) {
			if (book[i] != 0)
				return false;
		}
		return true;
	}

}
