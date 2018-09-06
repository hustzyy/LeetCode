package Number_36;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	// String str = sc.next();
	// char[] cs = str.toCharArray();
	// ���̶���һά�ַ�����

	public static void main(String[] args) {
		Solution that = new Solution();
		Scanner cin = new Scanner(System.in);
		char[][] ch = new char[9][9];
		for (int i = 0; i < 9; i++) {
			ch[i] = cin.next().toCharArray(); //ch[i]��ʾ��ά����ĵ�i+1�У����Խ������һ���ַ���ֱ��ת����һά������丳ֵ
		}
		if (that.isValidSudoku(ch)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		cin.close();
	}

	public boolean isValidSudoku(char[][] board) {
		int i = 0, j = 0, temp = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		// ��֤��
		for (; i < 9; i++) {
			for (j = 0; j < 9; j++) {
				temp = board[i][j] - '0';
				if (temp != -2) { //��ͳ���ַ� . 
					if (set.contains(temp)) {
						return false;
					} else {
						set.add(temp);
					}
				}
			}
			set.removeAll(set); //ע��ÿɨ��һ��Ҫ��ռ���
		}

		// ��֤��
		for (i = 0; i < 9; i++) {
			for (j = 0; j < 9; j++) {
				temp = board[j][i] - '0';  //ɨ���е���i��jλ�ü���
				if (temp != -2) {
					if (set.contains(temp)) {
						return false;
					} else {
						set.add(temp);
					}
				}
			}
			set.removeAll(set);
		}

		// ��֤3*3����
		int m, n;
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 3; j++) {
				for (m = 3 * i; m < 3 * (i + 1); m++) {
					for (n = 3 * j; n < 3 * (j + 1); n++) {
						temp = board[m][n] - '0';
						if (temp != -2) {
							if (set.contains(temp)) {
								return false;
							} else {
								set.add(temp);
							}
						}
					}
				}
				set.removeAll(set);
			}
		}
		return true;
	}

}
/*
53..7....
6..195...
.98....6.
8...6...3
4..8.3..1
7...2...6
.6....28.
...419..5
....8..79
*/
 