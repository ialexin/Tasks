import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import alexin.*;

public class Mains {

	public static void main(String[] args) throws IOException {
		File file = new File("data");
		Scanner in = new Scanner(file);
		
		Graph obj = new Graph(in);
		System.out.println("Default graph is: ");
		System.out.println(obj.toString());
		
		obj.biconComponents();
		
		System.out.println("\n\nIt is right ofk");
		in = new Scanner(file);
		Graph ob = new Graph(in);
		ob.biconComponents();
	}
}
