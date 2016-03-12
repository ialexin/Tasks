
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class ListElement {
	public ListElement(int m) {
		data = m;
	}

	ListElement next;
	int data;
}

class Lister {

	public ListElement head;

	/*
	 * input ListElement and add it in the tail of list
	 * 
	 * @include addBack()
	 * 
	 * @include printList
	 */
	void getList(File a) throws FileNotFoundException {
		Scanner in = new Scanner(a);
		while (in.hasNextInt()) {
			addFront(new ListElement(in.nextInt()));
		}
		printList();
		in.close();
	}

	/*
	 * change List adding element in the head
	 * 
	 * @param int data - integer which we should add in the list's head
	 * 
	 * @include class ListElement
	 */
	void addFront(ListElement a) {
		a.next = head;
		head = a;
	}
	
	private ListElement removeFront(){
		ListElement res = head;
		head = head.next;
		return res;
	}
	
	public boolean isEmpty(){
		return head == null;
	}
	
	
	void reverse() {
		ListElement newHead = null;
		while(!isEmpty()){
			ListElement top = removeFront();
			top.next = newHead;
			newHead = top;
		}
		head = newHead;
	}

	void printList() {
		ListElement t = head;
		while (t != null) {
			System.out.print(t.data + " ");
			t = t.next;
		}
		System.out.println();
	}

	/*
	 * 
	 */
	public String listToString() {
		reverse();
		ListElement a = head;
		StringBuilder str = new StringBuilder();

		while (a != null) {
			str.append(a.data);
			a = a.next;
			str.append(" ");
			
		}
		String res = str.deleteCharAt(str.length() - 1).toString();
		
		return res;
	}
}