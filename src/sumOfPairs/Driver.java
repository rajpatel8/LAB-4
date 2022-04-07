package sumOfPairs;

import java.util.Scanner;

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
	
	public void FindSumOfPairs(int sum) {
		Node ptrS = head; 
		Node ptrF;
	
		while(ptrS.next != null) {
			ptrF = ptrS.next;
			while(ptrF != null) {
				if(ptrF.data + ptrS.data == sum) {
					System.out.println(ptrF.data +" "+ ptrS.data);
				}
				ptrF = ptrF.next;
			}
			ptrS = ptrS.next;
		}
			
	}
	
}


public class Driver {

	public static void main(String[] args) {
		
		DoublyLinkedList dll = new DoublyLinkedList();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of elements: ");
		int size = sc.nextInt();
		
		System.out.print("Enter "+size+" elements in ascending order: ");
		while(size-- > 0) {
			dll.insert(sc.nextInt());
		}
				
		System.out.print("Enter the SUM value: ");
		int sum = sc.nextInt();
		
		dll.FindSumOfPairs(sum);

		sc.close();
		

	}

}
