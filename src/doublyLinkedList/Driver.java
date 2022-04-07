package doublyLinkedList;

import java.util.Scanner;

class Node {
	int data;
	Node next,prev;
	
	Node(int data){
		this.data = data;
		next = null;
		prev = null;
	}
}

class DoublyLinkedList {
	Node head;
	int length = 0;
	
	public void printDoublyLinkedList() {
		Node curr = head;
		if(curr == null) {
			System.out.println("The linked list is empty");
		}
		else {
			while(curr != null) {
				System.out.print(curr.data+" ");
				curr = curr.next;
			}
		}
		System.out.println("...");
	}
	
	public void printDoublyLinkedListR() {
		Node curr = head;
		while(curr.next != null) curr = curr.next;
		
		while(curr != null) {
			System.out.print(curr.data+" ");
			curr = curr.prev;
		}
		System.out.println("...");
	}
	
	public void insertAtPosition(int pos,int data) {
		Node newNode = new Node(data);
		Node curr = head;
		if(head == null) {
			head = newNode;
		}
		else if(pos == length+1) {
//			System.out.println("at end");
			while(curr.next != null) {
				curr = curr.next;
			}
			curr.next = newNode;
			newNode.prev = curr;
		}
		else if(pos == 1) {
//			System.out.println("at start");
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		else {
//			System.out.println("at pos "+data);
			int currPos = 1;
			while(currPos < pos - 1) {
				curr = curr.next;
				currPos++;
			}
			newNode.next = curr.next;
			newNode.prev = curr;
			curr.next = newNode;
			newNode.next.prev = newNode; 			
		}
		
		length++;
	}
	
	public void deleteNode(int data) {
		Node curr = head;
		if(curr == null) {
			System.out.print("The linkedlist is empty");
			return;
		}
		else if(curr.data == data) {
			head = curr.next;
			curr = head;
			curr.prev = null;
		}
		else {
			while(curr != null) {
				if(curr.data == data) {
					//do alteration
					curr.prev.next = curr.next;
					if(curr.next != null) {
						curr.next.prev = curr.prev;
					}

					break;
				}
				else {
					curr = curr.next;
				}
			}
		}
	}
	
	public void sortDoublyLinkedList() {
		Node ptrF = head;
		Node ptrB = head;
		
		while(ptrF.next != null) {
			ptrB = ptrF;
			while(ptrB != null) {
				if(ptrF.data > ptrB.data) {
					int temp = ptrF.data;
					ptrF.data = ptrB.data;
					ptrB.data = temp;
				}
				ptrB = ptrB.next;
			}
			ptrF = ptrF.next;
		}
		
	}
	
	public void reverseFirstKElements(int k) {
		//breaking the LinkedList into two parts;
		Node newHead;
		Node curr = head;
		
		if(k > length || k < 1) {
			System.out.println("Please do enter a valid position");
			return;
		}
		
		while(k > 1) {
			k--;
			curr = curr.next;
		}
		newHead = curr.next;
		curr.next = null;
		
		
		//now reversing the first LinkedList which is pointed by head pointer
		curr = head;
		Node next = head;
		Node prev = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			curr.prev = next;
			prev = curr;
			curr = next;
		}
		head = prev;
		
		//now combining both the linked list;
		
		curr = head;
		while(curr.next != null) {
			curr = curr.next;
		}
		
		curr.next = newHead;
		if(newHead != null) {
			newHead.prev = curr;
		}
		
		
	}
	
}

public class Driver {

	public static void main(String[] args) {
		DoublyLinkedList dl = new DoublyLinkedList();
		dl.insertAtPosition(1, 1);
		dl.insertAtPosition(2, 2);
		dl.insertAtPosition(3, 4);
		dl.insertAtPosition(3, 3);
		dl.insertAtPosition(1, 0);
		
		dl.printDoublyLinkedList();
		dl.printDoublyLinkedListR();

		dl.deleteNode(0);
		dl.deleteNode(2);
		dl.deleteNode(4);
		
		dl.printDoublyLinkedList();
		dl.printDoublyLinkedListR();
		
		dl.insertAtPosition(1, 2);
		dl.insertAtPosition(3, 5);
		dl.insertAtPosition(1, 4);
		
		dl.printDoublyLinkedList();
		
		dl.sortDoublyLinkedList();
		
		dl.printDoublyLinkedList();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter K to reverse K elements: ");
		dl.reverseFirstKElements(sc.nextInt());
		sc.close();
		
		dl.printDoublyLinkedList();
		
		

	}

}
