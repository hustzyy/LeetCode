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

	// ��һ���������
	public int firstUniqChar(String s) {
		int i, len = s.length();
		char temp;
		HashMap<Integer, Character> map = new HashMap<Integer, Character>();
		for (i = 0; i < len; i++) {
			map.put(i, s.charAt(i));
		}
		for (i = 0; i < len; i++) {
			temp = (char) (map.get(i)); // map.get(i)���ص����ַ���ASCII��ֵ��Ҫǿ������ת��
			map.remove(i); // ȥ������
			if (!map.containsValue(temp)) // �ж��Ƿ�Ψһ��Ψһ������ѭ��
				return i;
			else
				map.put(i, temp); // ��ԭ!!!
		}
		return -1;
	}

	// �������ռ任ʱ�䣬Ͱ�����˼��
	public int firstUniqChar2(String s) {
		int[] book = new int[26]; // ��Ŀ�����ַ���ֻ��Сд��ĸ�����Կ��ٶ�Ӧ�ı������
		int i;
		for (i = 0; i < s.length(); ++i) {
			++book[s.charAt(i) - 'a']; // ͳ�Ƴ��ֵĴ���
		}
		for (i = 0; i < s.length(); ++i) {
			if (book[s.charAt(i) - 'a'] == 1) // ��һ��Ψһ�ַ�
				return i;
		}
		return -1;
	}

	// ��������һ��Ψһ�ַ��״γ���λ�ú�������λ����ͬ,ʱ�临�Ӷ�O(n^2)
	public int firstUniqChar3(String s) {
		for (int i = 0; i < s.length(); ++i) {
			if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
				return i;
		}
		return -1;
	}

	// �������Ż���ʱ�临�Ӷ�O(n),������indexOf��lastIndexOf������
	public int firstUniqChar4(String s) {
		int result = -1; // Ĭ�ϲ�����
		for (char c = 'a'; c <= 'z'; ++c) { // ��ѭ�������̶�����Ӱ��ʱ�临�Ӷ�. O(k*n) == O(n)
			int index = s.indexOf(c); // ȡ���ַ����ַ������״γ��ֵ�λ�ã���ȡ-1
			if (index != -1 && index == s.lastIndexOf(c)) { // ������Ψһ
				result = result != -1 ? Math.min(result, index) : index; // Ψһ���ַ���ֹһ����ȡ������С��
			}
		}
		return result;
	}

}
