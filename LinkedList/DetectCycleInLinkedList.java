package LinkedList;

//We will take two pointers, namely fast and slow. 
//Fast pointer takes 2 steps ahead and slow pointer takes 2 points ahead.
//Iterate through the list until the fast pointer is equal to NULL. 
//This is because NULL indicates that there is no cycle present in the given list.
//Cycle can be detected when fast and slow pointers collide.
public class DetectCycleInLinkedList {

	public static boolean hasCycle(ListNode head) {
		// Empty check or Single Node
		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;

		// fast.next !=null => This check is when fast is at last position
		// fast.next.next !=null => this is when fast is at second last position
		while (fast.next != null && fast.next.next != null) {

			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}

		return false;

	}
}
