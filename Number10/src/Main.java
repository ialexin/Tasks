import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//бнопня опн Generate hashCode() and equals() in Source 


public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("input");
		Graph obj = new Graph();
		
		Scanner in = new Scanner(file);
		while (in.hasNext()){
			int vert1 = in.nextInt();
			int vert2 = in.nextInt();
			
			obj.add(vert1, vert2);
		}
		System.out.println("Default: ");
		System.out.println(obj.toString() + "\n");
		
		obj.remove(2, 3);
		obj.remove(5, 11);
		obj.remove(9, 10);
		obj.remove(2, 7);
		String str = obj.toString();
		in.close();
		System.out.println(str);
	}

}
