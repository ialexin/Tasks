package Neo;

import java.io.File;
import java.io.IOException;

public class Quotient {
	public Quotient(int n){
		Quotient.n = n;
	}

	
	static int n;
	public double getQuotient() throws IOException{
	System.out.println("*************");
	System.out.println("\n\nSize: " + n);
	File file = new File("data");
	Realise obj = new Realise(n);
	
	System.out.println(file.exists());
	
	double[][] mat1 = new double[n][n];
	double[][] mat2 = new double[n][n];
	mat1 = obj.randomize(mat1, n);
	mat2 = obj.randomize(mat2, n);
	
	long time = System.nanoTime();
	obj.multiply(mat1, mat2, n);
	long time1 = System.nanoTime() - time;
	System.out.println("mundane multiply takes:  " + time1 + " nano seconds");

	//transponate and multiply transponated matrix on default
	mat2 = obj.transponate(mat2, n);
	time = System.nanoTime();
	obj.transMultiply(mat1, mat2, n);
	long time2 = System.nanoTime() - time;
	
	System.out.println("transMultiply takes: " + time2 + " nano seconds");
	return (double)time1/(double)time2; 
	}
}
