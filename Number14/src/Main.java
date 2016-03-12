import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data");
		Scanner in = new Scanner(file);
		int n = in.nextInt();
		System.out.println("solution of Hanoi problem for " + n + " disks\n");
		Hanoi.hanoi(n);
		System.out.println("\n\nAnother one\n");
		System.out.println(Hanoi.rebuild(n).toString());
		
		
		System.out.println("\nRecoursive solution");
		System.out.println(Hanoi.RecHanoi(n).toString());
		in.close();
		
		System.out.println("\nIterations with stack:");
		System.out.println(Hanoi.hanoi(n).toString());

	}

}
