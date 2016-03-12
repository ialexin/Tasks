import java.util.ArrayList;

import org.junit.*;

public class Tester {
	
	@Test
	public void Checker() {
		ArrayList<Integer> arr = new ArrayList<Integer>();	
		arr.add(10);		arr.add(76);
		arr.add(13);	    arr.add(56);
		arr.add(25);		arr.add(3);
		arr.add(17);		arr.add(5);
		arr.add(26);		arr.add(8);
		arr.add(98);		arr.add(9);
		arr.add(23);		arr.add(2);
		arr.add(21);		arr.add(71);
		
		Realise.bitReverse(arr);
		
		String check = "[10, 26, 25, 23, 13, 98, 17, 21, 76, 8, 3, 2, 56, 9, 5, 71]";
	
		System.out.println("\n*****Must be true*****");
		System.out.println(check);
		
		System.out.println("\n*****Result*****");
		System.out.println(arr.toString());
		Assert.assertEquals(check, arr.toString());	
	}
}
