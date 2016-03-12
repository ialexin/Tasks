import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

import alexin.Graph;

public class Tests {
	@Test
	public void test1() throws IOException{
		File file = new File("data");
		Scanner in = new Scanner(file);
		
		Graph obj = new Graph(in);
		System.out.println("Default graph is: ");
		System.out.println(obj.toString());
		
		obj.biconComponents();
		Assert.assertEquals(obj.getBridges().toString(), "[(0, 1), (0, 2), (7, 8), (9, 10)]");
		Assert.assertEquals(obj.getComponents().toString(), "[[6, 3, 4, 5, 0], [11, 12, 9]]");
		Assert.assertEquals(obj.getcutPoints().toString(), "[0, 9]");
	}

	
	@Test
	public void test2() throws IOException {
		File file = new File("ex1");
		Scanner in = new Scanner(file);
		
		System.out.println("\n\n");
		Graph obj = new Graph(in);
		System.out.println("Default graph is: ");
		System.out.println(obj.toString());
		
		obj.biconComponents();
		
		Assert.assertEquals(obj.getBridges().toString(), "[(1, 2), (1, 3), (0, 5)]");
		Assert.assertEquals(obj.getComponents().toString(), "[[8, 4, 2], [6, 7, 1, 0]]");
		Assert.assertEquals(obj.getcutPoints().toString(), "[2, 1, 0]");
	}
	
	@Test
	public void test3() throws IOException{
		File file = new File("grob");
		Scanner in = new Scanner(file);
		
		System.out.println("\n\n");
		Graph obj = new Graph(in);
		System.out.println("Default graph is: ");
		System.out.println(obj.toString());
		
		obj.biconComponents();
		
	}
	
	@Test
	public void test4() throws IOException{
		File file = new File("grobx2");
		Scanner in = new Scanner(file);
		
		System.out.println("\n\n");
		Graph obj = new Graph(in);
		System.out.println("Dfault graph is: ");
		System.out.println(obj.toString());
		
		obj.biconComponents();
		
	}
}