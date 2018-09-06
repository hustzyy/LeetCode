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

	// 法一：使用java工具类在字符串、字符数组、整数之间转化
	public int reverse(int x) {
		char[] ch = String.valueOf(x).toCharArray();
		int low, high = ch.length - 1;
		char temp;
		if (ch[0] - '0' >= 0) { // 判断是否有负号，正号一般都会省略
			low = 0;
		} else {
			low = 1;
		}
		while (low < high) {
			temp = ch[low];
			ch[low++] = ch[high];
			ch[high--] = temp;
		}
		// Integer.parseInt()方法将字符串参数作为有符号的十进制整数进行解析（范围）。
		// 除了第一个字符可以是用来表示负值的 ASCII 减号 '-' 外，字符串中的字符都必须是十进制数字。
		// 这里要防止翻转过后的数值溢出。
		try {
			return Integer.parseInt(String.valueOf(ch));
		} catch (Exception e) {
			return 0;
		}
	}

	// 法二
	public int reverse2(int x) {
		long input = x > 0 ? x : -1 * x; // 1.求绝对值 2.long比int精度高，不需要强转
		long result = 0;
		while (input > 0) {
			result = result * 10 + input % 10;
			input /= 10;
		}
		if (x < 0) {
			result *= -1;
			if (result < Integer.MIN_VALUE) // 下溢
				return 0;
		} else {
			if (result > Integer.MAX_VALUE) // 上溢
				return 0;
		}
		return Long.valueOf(result).intValue();
	}

	//法二简化版
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
