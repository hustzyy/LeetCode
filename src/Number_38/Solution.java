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
				// ����һ����if else���жϣ����ظ�ֵһ���ȼ�����ظ�ֵ
				if (j + 1 < result.length() && result.charAt(j) == result.charAt(j + 1)) {
					count++;
				} else {
					str += count; // ����
					str += result.charAt(j); // ��
					count = 1;
				}
			}
			result = str;
		}
		return result;
	}

	public String countAndSay2(int n) {
		// String���ַ�������,StringBuffer���ַ�������
		StringBuffer result = new StringBuffer("1");
		StringBuffer str;
		int count;
		for (int i = 2; i <= n; i++) { // ���ѭ������2-nÿ������Ӧ������
			count = 1;
			str = new StringBuffer(); // ����
			for (int j = 0; j < result.length(); j++) { // �ڲ�ѭ�������ϸ��������м��㵱ǰ��������
				if (j + 1 < result.length() && result.charAt(j) == result.charAt(j + 1)) {
					count++;
				} else {
					str.append(count).append(result.charAt(j)); // ������
					count = 1; // ����
				}
			}
			result = str;
			// 1.����ֵ,ʵ������resultҲָ��str��ָ��Ķ��ڴ��еĵ�ַ,��������ջ�ڴ��еĵ�ַ������ͬ
			// 2.ͨ���ϸ�result�������ǰ�������в�����
		}
		return result.toString();
	}

}
