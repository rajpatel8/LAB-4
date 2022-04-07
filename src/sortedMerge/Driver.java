package sortedMerge;

class Node {
	int data;
	Node prev;
	Node next;
	
	Node(int data){
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}

class DoublyLinkedList {
	Node head;
	Node tail;
	
	public void print() {
		Node curr = head;
		if(curr == null) {
			System.out.println("The given Linked list is empty");
		}
		else {
			while(curr != null) {
				System.out.print(curr.data+" ");
				curr = curr.next;
			}
			System.out.println();
		}
	}
	
	public void insert(int data) {
		
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			newNode.prev = tail;
			tail.next = newNode;
			tail = newNode;
		}
		
	}
	
	public DoublyLinkedList sortedMerge(DoublyLinkedList List2) {
		DoublyLinkedList result = new DoublyLinkedList();
		
		Node curr1 = this.head;
		Node curr2 = List2.head;
		
		while(curr1 != null && curr2 != null) {
			if(curr1.data < curr2.data) {
				result.insert(curr1.data);
				curr1 = curr1.next;
			}
			else {
				result.insert(curr2.data);
				curr2 = curr2.next;
			}
		}
		
		while(curr1 != null) {
			result.insert(curr1.data);
			curr1 = curr1.next;
		}
		
		while(curr2 != null) {
			result.insert(curr2.data);
			curr2 = curr2.next;
		}
		
		return result;
	}
	
}

public class Driver {

	public static void main(String[] args) {
		
		DoublyLinkedList LinkedListOne = new DoublyLinkedList();
		DoublyLinkedList LinkedListTwo = new DoublyLinkedList();
		
		LinkedListOne.insert(1);
		LinkedListOne.insert(4);
		LinkedListOne.insert(9);
		LinkedListOne.insert(15);
		LinkedListOne.insert(19);
		LinkedListOne.insert(20);
		
		System.out.print("Sorted Doubly Linked List 1: ");
		LinkedListOne.print();
		
		LinkedListTwo.insert(0);
		LinkedListTwo.insert(5);
		LinkedListTwo.insert(6);
		LinkedListTwo.insert(25);
		
		System.out.print("Sorted Doubly Linked List 2: ");
		LinkedListTwo.print();
		
		DoublyLinkedList result = LinkedListOne.sortedMerge(LinkedListTwo);
		System.out.print("The new sorted merged Doubly Linked List is: ");
		result.print();


	}

}
