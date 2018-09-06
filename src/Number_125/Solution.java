package Number_125;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution that = new Solution();
		Scanner cin = new Scanner(System.in);
		String str = cin.nextLine(); // 包含空格的字符串
		if (that.isPalindrome(str)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		cin.close();
	}

	public boolean isPalindrome(String s) {
		s = s.toLowerCase(); // !!!该方法将字符串中的大写字母转化为小写，如果不是大小写字母，则不对其操作
		int low = 0, high = s.length() - 1;
		while (low < high) {
			if (!isValid(s.charAt(low))) {
				low++;
				continue;
			}
			if (!isValid(s.charAt(high))) {
				high--;
				continue;
			} // 通过跳出一次循环找到前后两个合法的比较位置
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
		int k = ch; // 低精度赋值给高精度会自动进行类型转换
		if ((k >= 48 && k <= 57) || (k >= 97 && k <= 122)) // 题目要求只考虑字母和数字
			return true;
		else
			return false;
	}

}
