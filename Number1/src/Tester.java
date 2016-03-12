import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;



public class Tester {
	@Test
	public void addBackTest() throws IOException{
		Lister obj = new Lister();
		
		
		File file = new File("test1");
		System.out.print("Actual List is: ");
		obj.getList(file);
		
		String expect = "13 11 18 7 12 8 5";
		obj.reverse();
		String res = obj.listToString();
		System.out.println("Reversed list is: " + res);
		
		Assert.assertEquals(expect, res);
	}
}