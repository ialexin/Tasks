import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

public class Tester {
	@Test
	public void test1() throws IOException{
		Graph obj = new Graph();
		File file = new File("test1");
		Scanner in = new Scanner(file);
		int vertex1;
		int vertex2;
		while(in.hasNext()){
			vertex1 = in.nextInt();
			vertex2 = in.nextInt();
			obj.add(vertex1, vertex2);
		}
		in.close();
		
				
	}

}
