import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		List obj = new List();
		
		obj.crList();
		obj.printList();
		boolean flag = obj.searhCircle();
		System.out.println("The circle does exist? ");
		System.out.println("Answer is: " + flag);
	}

}
