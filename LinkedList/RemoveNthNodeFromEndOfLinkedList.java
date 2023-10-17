package LinkedList;

//Take two dummy nodes, who’s next will be pointing to the head.
//Take another node to store the head, initially,s a dummy node(start), 
//and the next node will be pointing to the head. 
//The reason why we are using this extra dummy node is that there is an edge case.
//If the node is equal to the length of the LinkedList, then this slow will point to slow’s next→ next. 
//And we can say our dummy start node will be broken and will be connected to the slow next→ next.
//Start traversing until the fast pointer reaches the nth node.
//Now start traversing by one step both of the pointers until the fast pointers reach the end
//When the traversal is done, just do the deleting part.
//Make slow pointers next to the next of the slow pointer to ignore/disconnect the given node
//Last, return to the next start.

public class RemoveNthNodeFromEndOfLinkedList {

	public ListNode removeNthFromEnd(ListNode head , int n){
		ListNode start = new ListNode();
		start.next = head;  //Dummy node to point to head
		
		ListNode fast = start;
		ListNode slow = start;
		
		//Move Fast pointer upto n
		for(int i=1; i <= n ; i++){
			fast = fast.next;
		}
		//Till Fast reaches end of linked list.We need to move slow & fast by one step
		while(fast.next !=null){
			slow = slow.next;
			fast=fast.next;
		}
		//Delete the link
		slow.next = slow.next.next;
		
		return slow.next;
		
	}
}
