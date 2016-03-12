import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Mainful {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("data");
		Scanner in = new Scanner(file);
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		while(in.hasNextInt()){
			arr.add(in.nextInt());
		}
		
		System.out.println("Before reversing: " + arr.toString());
		arr = Realise.bitReverse(arr);
		System.out.println("Result: " + arr.toString());
		in.close();
	}

}
