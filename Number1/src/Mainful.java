import java.io.File;
import java.io.IOException;

public class Mainful {

	public static void main(String[] args) throws IOException {
		Lister basic = new Lister();
		File file = new File("data");
		
		System.out.println("*****Input*****");
		basic.getList(file);
		
		basic.reverse();
		System.out.println("\n\n*****Output*****");
		basic.printList();
	
	}
}