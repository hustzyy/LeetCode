package Number_350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Solution that = new Solution();
		Scanner cin = new Scanner(System.in);
		int i = 0;
		int len1 = cin.nextInt();
		int[] nums1 = new int[len1];
		for (; i < len1; i++)
			nums1[i] = cin.nextInt();
		int len2 = cin.nextInt();
		int[] nums2 = new int[len2];
		for (i = 0; i < len2; i++)
			nums2[i] = cin.nextInt();
		int[] nums = that.intersect(nums1, nums2);
		System.out.println(Arrays.toString(nums));
		cin.close();
	}

	//ע����ĿҪ��ÿ��Ԫ�س��ֵĴ�����Ӧ��Ԫ�������������г��ֵĴ���һ��
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		ArrayList<Integer> temp = new ArrayList<Integer>();  //��ʱ��Ź���Ԫ��
		int i = 0, j = 0; //����ֱ�ָ��������Ԫ�ص�ָ��
		while(i < nums1.length && j < nums2.length){
			if(nums1[i] == nums2[j]){
				temp.add(nums1[i]);
				++i;
				++j;
			}else if(nums1[i] > nums2[j]){
				++j;
			}else{
				++i;
			}
		}
		int[] nums = new int[temp.size()];
		for (i = 0; i < temp.size(); i++) {
			nums[i] = temp.get(i);
		}
		return nums;
	}
	
	//�ڲ�����û����ԭ��
	public int[] intersect2(int[] nums1, int[] nums2) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Integer> search = new ArrayList<Integer>();
		int i = 0;
		for (; i < nums1.length; i++) {
			search.add(nums1[i]);
		}
		for (i = 0; i < nums2.length; i++) {
			if (search.contains(nums2[i])) {
				temp.add(nums2[i]);
				search.remove(nums2[i]);
			}
		}
		int[] nums = new int[temp.size()];
		for (i = 0; i < temp.size(); i++) {
			nums[i] = temp.get(i);
		}
		return nums;
	}

}
