package Number_344;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution that = new Solution();
		Scanner cin = new Scanner(System.in);
		String str = cin.next();
		str = that.reverseString(str);
		System.out.println(str);
		cin.close();
	}

	public String reverseString(String s) {
		char[] ch = s.toCharArray();
		char temp;
		int low = 0, high = ch.length - 1;
		while (low < high) {
			temp = ch[low];
			ch[low++] = ch[high];
			ch[high--] = temp;
		}
		return String.valueOf(ch);
//		return new String(ch);
	}

}
