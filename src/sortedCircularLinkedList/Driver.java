package sortedCircularLinkedList;

class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
}

class SortedCircularLinkedList{
	Node head;
	
	public void printSorted() {
		Node curr = head;
		if(curr == null) {
			System.out.println("The list is empty!");
		}
		else {
			System.out.print("Printing Sorted Circular Linked List: ");
			System.out.print(curr.data+" ");
			curr = curr.next;
			while(curr != head) {
				System.out.print(curr.data+" ");
				curr = curr.next;
			}
			System.out.println();
		}
	}
	
	public void insertAtFront(int data,Node newNode) {
		newNode.next = head;
		Node curr = head;
		while(curr.next != head) {
			curr = curr.next;
		}
		curr.next = newNode;
		head = newNode;
		
	}
	
	public void sortedInsert(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			newNode.next = head;
		}
		else {
			Node curr = head;
			if(curr.data > data) {
				this.insertAtFront(data,newNode);
			}
			else {
				while(curr.next.data < data && curr.next != head) {
					curr = curr.next;
				}
				if(curr.next == head) {
					curr.next = newNode;
					newNode.next = head;
				}
				else {
					newNode.next = curr.next;
					curr.next = newNode;
				}
			}
		}
	}
}

public class Driver {

	public static void main(String[] args) {
		
		SortedCircularLinkedList scll = new SortedCircularLinkedList();
		
		scll.sortedInsert(2);
		scll.sortedInsert(8);
		scll.sortedInsert(3);
		scll.sortedInsert(9);
		scll.sortedInsert(1);
		scll.sortedInsert(4);
		
		scll.printSorted();
		

	}

}
