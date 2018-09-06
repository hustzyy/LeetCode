package Number_2;

import java.util.Scanner;

public class Solution {// 错误解法，没有考虑到int的范围

	public static void main(String[] args) {
		Solution that = new Solution();
		Scanner cin = new Scanner(System.in);
		System.out.println("输入l1单链表所表示的整数：");
		int N1 = cin.nextInt();
		System.out.println("输入l2单链表所表示的整数：");
		int N2 = cin.nextInt();
		ListNode l1 = that.createList(N1);
		ListNode l2 = that.createList(N2);
		ListNode l3 = that.addTwoNumbers(l1, l2);
		while (l3 != null) {
			System.out.println(l3.val);
			l3 = l3.next;
		}
		cin.close();
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int i = 0, j = 0, k = 1;
		while (l1 != null) {
			i += l1.val * k;
			l1 = l1.next;
			k *= 10;
		}
		k = 1;
		while (l2 != null) {
			j += l2.val * k;
			l2 = l2.next;
			k *= 10;
		}
		return createList(i + j); // 当两个很大的int相加可能会超出int的范围
	}

	public ListNode createList(int num) {
		int temp = 0;
		ListNode list = null, rear = null, p = null;
		if (num == 0) {
			list = new ListNode(num);
			list.next = null;
		} else {
			while (num > 0) {
				temp = num % 10;
				num = num / 10;
				if (list == null) {
					list = new ListNode(temp);
					rear = list;
					list.next = null;
				} else {
					p = new ListNode(temp);
					p.next = null;
					rear.next = p;
					rear = p;
				}
			}
		}
		return list;
	}
}
