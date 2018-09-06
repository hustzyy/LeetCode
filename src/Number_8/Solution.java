package Number_8;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution that = new Solution();
		Scanner cin = new Scanner(System.in);
		String str = cin.nextLine(); // 包含空格的字符串
		System.out.println(that.myAtoi(str));
		cin.close();
	}

	public int myAtoi(String str) {
		int sign = 1, index = 0;
		long result = 0;
		while (index < str.length() && str.charAt(index) == ' ')// 指针指到第一个非空格字符或者未找到非空格字符
			++index;
		if (index < str.length() && str.charAt(index) == '-') {// 防止数组越界
			sign = -1;
			++index;
		} else if (index < str.length() && str.charAt(index) == '+') {
			++index;
		}
		while (index < str.length() && Character.isDigit(str.charAt(index))) {
			result = result * 10 + (str.charAt(index) - '0');
			if (result > Integer.MAX_VALUE) {// 大于等于边界都是取边界
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE; // 放在这里判断而不放在最后是因为防止最后累加超出long的范围
			}
			++index;
		}
		return (int) result * sign;
	}

}
