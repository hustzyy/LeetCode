package Number_36;

import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	// String str = sc.next();
	// char[] cs = str.toCharArray();
	// 键盘读入一维字符数组

	public static void main(String[] args) {
		Solution that = new Solution();
		Scanner cin = new Scanner(System.in);
		char[][] ch = new char[9][9];
		for (int i = 0; i < 9; i++) {
			ch[i] = cin.next().toCharArray(); //ch[i]表示二维数组的第i+1行，所以将输入的一个字符串直接转化成一维数组对其赋值
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
		// 验证行
		for (; i < 9; i++) {
			for (j = 0; j < 9; j++) {
				temp = board[i][j] - '0';
				if (temp != -2) { //不统计字符 . 
					if (set.contains(temp)) {
						return false;
					} else {
						set.add(temp);
					}
				}
			}
			set.removeAll(set); //注意每扫完一行要清空集合
		}

		// 验证列
		for (i = 0; i < 9; i++) {
			for (j = 0; j < 9; j++) {
				temp = board[j][i] - '0';  //扫描列调换i和j位置即可
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

		// 验证3*3宫格
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
 