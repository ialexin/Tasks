import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class List {
	 Element head;
	 Element tail;

	public void crList() throws IOException{
		File file = new File("data");
		Scanner in = new Scanner(file);
		
		while(in.hasNextInt()){
			Element data = new Element(in.nextInt());
			addBack(data);
		}
		in.close();
	}
	private void addBack(Element a) {
        if (head != null) {
            tail.next = a;
            tail = tail.next;
        }
        else {
            head = a;
            tail = head;
        }
	}

	public boolean searhCircle() {
		Element slow = head;
		Element fast = head;
		
		boolean odd = false;
		
		do {
			if (fast == null) {
				return false;
			}
			fast = fast.next;
			
			if (odd) {
				slow = slow.next;
			}
			odd = !odd;
			
		} while(slow.data != fast.data);
		
		return true;
	}
	
	public void printList(){
		Element a = head;
		while(a.next != null){
			System.out.print(a.data + " ");
			a = a.next;
		}
	}
}
