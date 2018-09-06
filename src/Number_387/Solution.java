package Number_387;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution that = new Solution();
		Scanner cin = new Scanner(System.in);
		String str = cin.next();
		System.out.println(that.firstUniqChar4(str));
		cin.close();
	}

	// 法一：暴力求解
	public int firstUniqChar(String s) {
		int i, len = s.length();
		char temp;
		HashMap<Integer, Character> map = new HashMap<Integer, Character>();
		for (i = 0; i < len; i++) {
			map.put(i, s.charAt(i));
		}
		for (i = 0; i < len; i++) {
			temp = (char) (map.get(i)); // map.get(i)返回的是字符的ASCII码值，要强制类型转换
			map.remove(i); // 去除本身
			if (!map.containsValue(temp)) // 判断是否唯一，唯一则跳出循环
				return i;
			else
				map.put(i, temp); // 还原!!!
		}
		return -1;
	}

	// 法二：空间换时间，桶排序的思想
	public int firstUniqChar2(String s) {
		int[] book = new int[26]; // 题目假设字符串只含小写字母，所以开辟对应的标记数组
		int i;
		for (i = 0; i < s.length(); ++i) {
			++book[s.charAt(i) - 'a']; // 统计出现的次数
		}
		for (i = 0; i < s.length(); ++i) {
			if (book[s.charAt(i) - 'a'] == 1) // 第一个唯一字符
				return i;
		}
		return -1;
	}

	// 法三：第一个唯一字符首次出现位置和最后出现位置相同,时间复杂度O(n^2)
	public int firstUniqChar3(String s) {
		for (int i = 0; i < s.length(); ++i) {
			if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
				return i;
		}
		return -1;
	}

	// 法三的优化：时间复杂度O(n),体现在indexOf和lastIndexOf方法中
	public int firstUniqChar4(String s) {
		int result = -1; // 默认不存在
		for (char c = 'a'; c <= 'z'; ++c) { // 该循环次数固定，不影响时间复杂度. O(k*n) == O(n)
			int index = s.indexOf(c); // 取该字符在字符串中首次出现的位置，无取-1
			if (index != -1 && index == s.lastIndexOf(c)) { // 存在且唯一
				result = result != -1 ? Math.min(result, index) : index; // 唯一的字符不止一个，取索引最小的
			}
		}
		return result;
	}

}
