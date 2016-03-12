package Neo;
import Neo.*;

import java.io.IOException;



public class Matrix {
	

	public static void main(String[] args) throws IOException {
		Quotient arg1 = new Quotient(25);
		double ratio = arg1.getQuotient();
		System.out.println("ratio is: " + ratio);
		
		Quotient arg2 = new Quotient(150);
		ratio = arg2.getQuotient();
		System.out.println("ratio is: " + ratio);
		
		Quotient arg3 = new Quotient(260);
		ratio = arg3.getQuotient();
		System.out.println("ratio is: " + ratio);
		
		Quotient arg4 = new Quotient(500);
		ratio = arg4.getQuotient();
		System.out.println("ratio is: " + ratio);
		
		Quotient arg5 = new Quotient(1000);
		ratio = arg5.getQuotient();
		System.out.println("ratio is: " + ratio);
		
		Quotient arg6 = new Quotient(2012);
		ratio = arg6.getQuotient();
		System.out.println("ratio is: " + ratio);
		
		}
}
