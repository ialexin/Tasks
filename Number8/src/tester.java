import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class tester {
	@Test 
	public void test1() throws IOException{
		File file = new File("test1");
		BufferedReader in = new BufferedReader(new FileReader(file));
		
        TreeElement root = TreeElement.readTreeElement(new BufferedReader(
                new FileReader(file)));
        System.out.println("Result is : ");
        System.out.println(root.toInfix() + "\n");
        String str = "a*b/c*(d+e)";
        in.close();
        Assert.assertEquals(root.toInfix().toString(), str);
	}
	
	@Test 
	public void test2() throws IOException{
		File file = new File("test2");
		BufferedReader in = new BufferedReader(new FileReader(file));
		
        TreeElement root = TreeElement.readTreeElement(new BufferedReader(
                new FileReader(file)));
        System.out.println("Result is : ");
        System.out.println(root.toInfix() + "\n");
        String str = "a/(b-(c+d))*e-(f+g+h)";
        in.close();
        Assert.assertEquals(root.toInfix().toString(), str);
	}
	
	@Test
	public void test3() throws IOException{
		File file = new File("test3");
		BufferedReader in = new BufferedReader(new FileReader(file));
		
        TreeElement root = TreeElement.readTreeElement(new BufferedReader(
                new FileReader(file)));
        System.out.println("Result is : ");
        System.out.println(root.toInfix() + "\n");
        String str = "a*b-(c+d)";
        in.close();
        Assert.assertEquals(root.toInfix().toString(), str);
	}
	
	@Test
	public void test4() throws IOException{
		File file = new File("test4");
		BufferedReader in = new BufferedReader(new FileReader(file));
		
        TreeElement root = TreeElement.readTreeElement(new BufferedReader(
                new FileReader(file)));
        System.out.println("Result is : ");
        System.out.println(root.toInfix() + "\n");
        String str = "a/(b*c)*(d+e)";
        in.close();
        Assert.assertEquals(root.toInfix().toString(), str);
	}
}