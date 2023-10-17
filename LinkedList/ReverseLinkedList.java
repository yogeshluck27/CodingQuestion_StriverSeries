package LinkedList;

class ListNode {
	int val;
	ListNode next;

	ListNode() {

	}

	public ListNode(int val) {
		super();
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		super();
		this.val = val;
		this.next = next;
	}
}

public class ReverseLinkedList {

	public static ListNode reverseList(ListNode head) {
		ListNode newHead = null; //Dummy Node
		while (head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}

}
