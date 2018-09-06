package Number_38;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution that = new Solution();
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		System.out.println(that.countAndSay2(n));
		cin.close();
	}

	public String countAndSay(int n) {
		String result = "1";
		for (int i = 2; i <= n; i++) {
			int count = 1;
			String str = "";
			for (int j = 0; j < result.length(); j++) {
				// 这里一定是if else的判断，有重复值一定先计算出重复值
				if (j + 1 < result.length() && result.charAt(j) == result.charAt(j + 1)) {
					count++;
				} else {
					str += count; // 几个
					str += result.charAt(j); // 几
					count = 1;
				}
			}
			result = str;
		}
		return result;
	}

	public String countAndSay2(int n) {
		// String是字符串常量,StringBuffer是字符串变量
		StringBuffer result = new StringBuffer("1");
		StringBuffer str;
		int count;
		for (int i = 2; i <= n; i++) { // 外层循环计算2-n每个数对应的序列
			count = 1;
			str = new StringBuffer(); // 重置
			for (int j = 0; j < result.length(); j++) { // 内层循环根据上个数的序列计算当前数的序列
				if (j + 1 < result.length() && result.charAt(j) == result.charAt(j + 1)) {
					count++;
				} else {
					str.append(count).append(result.charAt(j)); // 几个几
					count = 1; // 重置
				}
			}
			result = str;
			// 1.对象赋值,实际是让result也指向str所指向的堆内存中的地址,而两者在栈内存中的地址并不相同
			// 2.通过上个result计算出当前数的序列并更新
		}
		return result.toString();
	}

}
