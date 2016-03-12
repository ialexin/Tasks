package Neo;

import java.io.IOException;
import org.junit.*;

public class Tester {
	Realise obj = new Realise(4); 
	
	
	@Test
	public void multip() throws IOException{
		int n = Realise.n;
		
		double[][] mat1 = new double[n][n];
		mat1[0][0] = 5;		mat1[0][1] = 8;		mat1[0][2] = 3;		mat1[0][3] = 6;
		mat1[1][0] = 7;		mat1[1][1] = 2;		mat1[1][2] = 10;	mat1[1][3] = 2;
		mat1[2][0] = 18;	mat1[2][1] = 1;		mat1[2][2] = 5;		mat1[2][3] = 4;
		mat1[3][0] = 6;		mat1[3][1] = 0;		mat1[3][2] = 11;	mat1[3][3] = 3;
		
		
		
		double[][] mat2 = new double[n][n];
		mat2[0][0] = 8;		mat2[0][1] = 2;		mat2[0][2] = 10;	mat2[0][3] = 4;
		mat2[1][0] = 3;		mat2[1][1] = 1;		mat2[1][2] = 5;		mat2[1][3] = 8;
		mat2[2][0] = 4;		mat2[2][1] = 6;		mat2[2][2] = 7;		mat2[2][3] = 1;
		mat2[3][0] = 0;		mat2[3][1] = 9;		mat2[3][2] = 13;	mat2[3][3] = 1;
		
		
		double [][] res1 = obj.multiply(mat1, mat2, n);
		obj.output(res1, n);
		
		double [][] res2 = new double[n][n];
		res2[0][0] = 76;	res2[0][1] = 90;	res2[0][2] = 189;	res2[0][3] = 93;
		res2[1][0] = 102;	res2[1][1] = 94;	res2[1][2] = 176;	res2[1][3] = 56;
		res2[2][0] = 167;	res2[2][1] = 103;	res2[2][2] = 272;	res2[2][3] = 89;
		res2[3][0] = 92;	res2[3][1] = 105;	res2[3][2] = 176;	res2[3][3] = 38;
		System.out.println();
		

		
		Assert.assertArrayEquals(res1, res2);	
		}
	
	@Test 
	public void multipTran() throws IOException{
		int n = 4;
		
		double[][] mat1 = new double[n][n];
		mat1[0][0] = 5;		mat1[0][1] = 8;		mat1[0][2] = 3;		mat1[0][3] = 6;
		mat1[1][0] = 7;		mat1[1][1] = 2;		mat1[1][2] = 10;	mat1[1][3] = 2;
		mat1[2][0] = 18;	mat1[2][1] = 1;		mat1[2][2] = 5;		mat1[2][3] = 4;
		mat1[3][0] = 6;		mat1[3][1] = 0;		mat1[3][2] = 11;	mat1[3][3] = 3;
		
		
		
		double[][] mat2 = new double[n][n];
		mat2[0][0] = 8;		mat2[0][1] = 2;		mat2[0][2] = 10;	mat2[0][3] = 4;
		mat2[1][0] = 3;		mat2[1][1] = 1;		mat2[1][2] = 5;		mat2[1][3] = 8;
		mat2[2][0] = 4;		mat2[2][1] = 6;		mat2[2][2] = 7;		mat2[2][3] = 1;
		mat2[3][0] = 0;		mat2[3][1] = 9;		mat2[3][2] = 13;	mat2[3][3] = 1;
		
		mat2 = obj.transponate(mat2, n);
		double [][] res1 = obj.transMultiply(mat1, mat2, n);
		obj.output(res1, n);
		
		double [][] res2 = new double[n][n];
		res2[0][0] = 76;	res2[0][1] = 90;	res2[0][2] = 189;	res2[0][3] = 93;
		res2[1][0] = 102;	res2[1][1] = 94;	res2[1][2] = 176;	res2[1][3] = 56;
		res2[2][0] = 167;	res2[2][1] = 103;	res2[2][2] = 272;	res2[2][3] = 89;
		res2[3][0] = 92;	res2[3][1] = 105;	res2[3][2] = 176;	res2[3][3] = 38;
		System.out.println();
	
		
		Assert.assertArrayEquals(res1, res2);	
		}
	
	@Test 
	public void justMultiply() throws IOException{
		int n = Realise.n;
		
		double[][] mat1 = new double[n][n];
		mat1 = obj.randomize(mat1, n);
		double[][] mat2 = new double[n][n];
		mat2 = obj.randomize(mat2, n);
		
		
		double [][] res1 = obj.multiply(mat1, mat2, n);
		obj.output(res1, n);
		Assert.assertNotNull(res1);
	}
	
	@Test 
	public void transporatedMultiply() throws IOException{
		int n = Realise.n;
		
		double[][] mat1 = new double[n][n];
		mat1 = obj.randomize(mat1, n);
		double[][] mat2 = new double[n][n];
		mat2 = obj.randomize(mat2, n);
		
		
		double [][] res2 = obj.transMultiply(mat1, mat2, n);
		obj.output(res2, n);
		Assert.assertNotNull(res2);
	}

	
	
}
