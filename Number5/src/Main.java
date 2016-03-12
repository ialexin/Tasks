import java.util.Random;

public class Main {

	public static void main(String[] args) {
		int leftBorder = 1;
		int rightBorder = 100;
		Random ran = new Random();
		BinarySearch obj1 = new BinarySearch();
		boolean flag = true;
		
		for (int x = 1; x <= 100; x++){
		System.out.println("planned number: " + x);
		
		System.out.println("Number of flicks using Binary search strategy: " + obj1.dichotomy(x, leftBorder, rightBorder));
		int k = theWorstCase.findX(x);
		System.out.println("In the worst case: " + k + "\n");
		if (k > 9){
			flag = false;
		}
		System.out.println("**********");
		}
		
		System.out.println("Test PASSED?");
		System.out.println(flag);
	}

}
