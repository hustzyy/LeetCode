package Number_2;

import java.util.Scanner;

public class Revision {

	public static void main(String[] args) {
		Revision that = new Revision();
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
		ListNode head = new ListNode(0); // 定义头节点（大大缩减程序执行时间）
		ListNode rear = head, p = null; // 定于尾指针
		int temp = 0, flag = 0;
		while (l1 != null && l2 != null) {
			temp = l1.val + l2.val + flag; // 加上低位的进位
			flag = temp / 10; // 更新下一次的进位
			p = new ListNode(temp % 10); // 取个位
			rear.next = p;
			rear = p;
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) { // 考虑两单链表不等长的情况
			if (flag == 0) { // 如果没有进位，可以将该单链表剩余的节点直接复制到新的单链表上
				rear.next = l1;
				break;
			} else {
				temp = l1.val + flag;
				flag = temp / 10;
				p = new ListNode(temp % 10);
				p.next = null;
				rear.next = p;
				rear = p;
			}
			l1 = l1.next;
		}

		while (l2 != null) {
			if (flag == 0) {
				rear.next = l2;
				break;
			} else {
				temp = l2.val + flag;
				flag = temp / 10;
				p = new ListNode(temp % 10);
				p.next = null;
				rear.next = p;
				rear = p;
			}
			l2 = l2.next;
		}

		if (flag == 1) { // 考虑相加之后形成的单链表长度超过原有两单链表，此时会产生进位
			p = new ListNode(1);
			p.next = null;
			rear.next = p;
		}
		return head.next;
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
