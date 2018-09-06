package Number_48;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution that = new Solution();
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int[][] nums = new int[n][n];
		int i, j;
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				nums[i][j] = cin.nextInt();
		that.rotate2(nums);
		for (i = 0; i < n; i++)
			System.out.println(Arrays.toString(nums[i]));
		cin.close();
	}

	public void rotate(int[][] matrix) {
		// �������Խ���Ϊ����ת
		int i, j, temp = 0, n = matrix.length; // matrix.length��ʾ��ά���������(�˴������Ƿ���������������)��������matrix[i].length��ʾ��i�еĳ���
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				if (i < j) {
					temp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = temp;
				}

		// ��������ת
		for (i = 0; i < n; i++) {
			for (j = 0; j < n / 2; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = temp;
			}
		}
	}
	
	public int[][] rotate2(int[][] matrix) {
		int i,j, n = matrix.length;
		int[][] temp = new int[n][n]; //���¿ռ�����ת�������֤ǰ���������
		for(i = 0; i < n; i++)
			for(j = 0; j < n; j++)
				temp[j][n - 1 - i] = matrix[i][j]; 
		return temp;
	}

}
