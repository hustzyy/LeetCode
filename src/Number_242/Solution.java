package Number_242;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution that = new Solution();
		Scanner cin = new Scanner(System.in);
		String s = cin.next();
		String t = cin.next(); // next()方法不可以读取空格,空格即分隔符
		boolean flag = that.isAnagram(s, t);
		if (flag) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		cin.close();
	}

	// 法一：空间换时间(有问题)
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		long[] book = new long[26]; // 问题所在，如果输入字符串很长，导致在统计某一个字符出现次数时数量级超出了int甚至是long
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
