package LinkedList;

public class MergedTwoSortedList {

	// Step 1: Create two pointers, say l1 and l2.
	// Compare the first node of both lists and find the small among the two.
	// Assign pointer l1 to the smaller value node.
	// Step 2: Create a pointer, say res, to l1.
	// An iteration is basically iterating through both lists till
	// the value pointed by l1 is less than or equal to the value pointed by l2.
	// Step 3: Start iteration. Create a variable, say, temp.
	// It will keep track of the last node sorted list in an iteration.
	// Step 4: Once an iteration is complete, link node pointed by temp to node
	// pointed by l2. Swap l1 and l2.
	// Step 5: If any one of the pointers among l1 and l2 is NULL,
	// then move the node pointed by temp to the next higher value node.

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		//L1 should be assigned to smaller one ..
		//Swap l1 and l2 if l1 is greater
		if (l1.val > l2.val) {
			ListNode tmp = l1;
			l1 = l2;
			l2 = tmp;
		}
		ListNode res = l1;
		while (l1 != null && l2 != null) {
			ListNode tmp = null;
			while (l1 != null && l1.val <= l2.val) {
				tmp = l1; //we store in tmp to get Which one was last smallest node
				l1 = l1.next;
			}
			tmp.next = l2; // break the link
			// Swap l1 & l2
			ListNode temp = l1;
			l1 = l2;
			l2 = temp;

		}
		return res;
	}
}
