package circularLinkedList;

class Node{
	int data;
	Node next;
	Node(int d){
		data = d;
		next = null;
	}
}

class CircularLinkedList{
	Node head;
	int length = 0;
	
	public void printCircularLinkedList() {
		Node curr = head;
		if(curr == null) {
			System.out.print("The circular linked list is empty");
		}
		else {
			System.out.print(curr.data+" ");
			curr = curr.next;
			while(curr != head) {
				System.out.print(curr.data+" ");
				curr = curr.next;
			}
		}
		System.out.println();
	}
	
	public void insertAtHead(int data) {
		Node newNode = new Node(data);
		Node curr = head;
		length++;
		if(curr == null) {
			head = newNode;
			newNode.next = head;
		}
		else {
			newNode.next = head;
			head = newNode;
			// now go to last element and resign it to the newly created node in both if and else case //
			while(curr.next != head.next) {
				curr = curr.next;
			}
			curr.next = head;
		}
	}
	
	public void insertAtLast(int data) {
		Node newNode = new Node(data);
		Node curr = head;
		length++;
		if(curr == null) {
			head = newNode;
			newNode.next = head;
		}
		else {
			while(curr.next != head) {
				curr = curr.next;
			}
			curr.next = newNode;
			newNode.next = head;
		}
		
	}
	
	public void insertAfterNode(int n,int data) {
		Node newNode = new Node(data);
		Node curr = head;
		
		if(n > length || n < 1) {
			System.out.print("Please enter valid position to insert");
			return;
		}
		else if(n == length) {
			this.insertAtLast(data);
		}
		else if(n == 1) {
			this.insertAtHead(data);
		}
		else {
			int currPos = 1;
			while(currPos < n) {
				currPos++;
				curr = curr.next;
			}
			newNode.next = curr.next;
			curr.next = newNode;
			length++;
		}
		
	}
	
	public void deleteData(int data) {
		Node curr = head;
		Node prevHead = head;
		if(curr == null) {
			System.out.print("Circular Linked List is empty");
			return;
		}
		else if(curr.data == data) {
			head = curr.next;
			// update last element link coz its circula
			while(curr.next != prevHead) {
				curr = curr.next;
			}
			curr.next = head;
		}
		else {
			while(curr.next.data != data) {
				curr = curr.next;
			}
			curr.next = curr.next.next;
		}
		length--;
	}
	
	public void deleteAtPosition(int pos) {
		Node curr = head;
		int currPos = 1;
		if(curr == null) {
			System.out.print("The linked list is emtpy");
			return;
		}
		else if(pos < 1 || pos > length) {
			System.out.println("Please enter valid position");
			return;
		}
		else if(pos == 1) {
			while(curr.next != head) {
				curr = curr.next;
			}
			curr.next = curr.next.next;
			head = head.next;
		}
		else {
			while(currPos < pos-1) {
				currPos++;
				curr = curr.next;
			}
			curr.next = curr.next.next;
		}
		length--;
	}
	
	public boolean findElement(int data) {
		Node curr = head;
		while(curr != null && curr.next != head) {
			if(curr.data == data) {
				return true;
			}
			else {
				curr = curr.next;
			}
		}
		return false;
	}
	
}


public class Driver {

	public static void main(String[] args) {
		CircularLinkedList cl = new CircularLinkedList();
		
		cl.insertAtHead(2);
		cl.insertAtHead(1);
		
		cl.printCircularLinkedList();
		
		cl.insertAtLast(4);
		cl.insertAtLast(6);

		
		cl.printCircularLinkedList();
		
		cl.insertAfterNode(2,3);
		cl.insertAfterNode(4,5);
		cl.insertAfterNode(6,8);
		cl.insertAfterNode(6,7);

		
		cl.printCircularLinkedList();
		
		cl.deleteData(1);
		cl.deleteData(8);
		cl.deleteData(7);

		
		cl.printCircularLinkedList();
		
		cl.deleteAtPosition(0);
		cl.printCircularLinkedList();
		cl.deleteAtPosition(1);
		cl.printCircularLinkedList();
		cl.deleteAtPosition(3);
		cl.printCircularLinkedList();
		cl.deleteAtPosition(5);
		cl.printCircularLinkedList();
		
		
		
		
		
		
		
		

	}

}
