package Neo;

import java.io.*;
import java.util.*;
import static java.lang.System.out;


public class Realise {
	
	public Realise(int n){
		Realise.n = n;
	}
	
	public static int n;
	Scanner in;

	/*****public methods
	 
	
	//multiply matrixes
	/*
	 *@return result of multiplication
	 *@throws IOException 
	 *@param mat1, mat2(multyplied matrixes) and their size n
	 */
	public double[][] multiply(double[][] mat1, double[][] mat2, int n) throws IOException{
		double[][] c = new double[n][n];
		for (int i = 0; i < n; i++)
			for(int j = 0; j < n; j++){
				for(int k=0; k < n; k++)
					c[i][j] = c[i][j] + mat1[i][k] * mat2[k][j];
			}
		return c;
		
	}
	
	// multiply transporated matrix 
	/*
	 * @throws IOException
	 * @param mat1, mat2(multyplied matrixes) and their size n
	 * @return result of multiplication
	 */
	public double[][] transMultiply(double[][] mat1, double[][] mat2, int n) throws IOException{
double[][] c = new double[n][n];
		for (int i = 0; i < n; i++)
			for(int j = 0; j < n; j++){
				for(int k=0; k < n; k++)
					c[i][j] = c[i][j] + mat1[i][k] * mat2[j][k];
			}
		return c;
	}
	
	/*
	 * transponate matrixes 
	 * @param matrix for transporating and its size
	 * @return transporated matrix
	 */
	
	public double[][] transponate (double[][] matr, int n) throws IOException{
		
		double[][] tran = new double[n][n];
		for(int i = 0; i < n; ++i)
			  for(int j = 0; j < n; ++j)
			    tran[i][j] = matr[j][i];
		return tran;
	}
	
	/* output multyplied matrixes
	 * @throws IOException **
	 * */
	
	public void output (double[][] matr, int n) throws IOException{
		BufferedWriter oute = new BufferedWriter(new FileWriter("out.txt"));
		DataOutputStream crutch = new DataOutputStream(new FileOutputStream("out.txt") );
		
		for(int i = 0; i < n; i++){
			out.println();
			oute.newLine();
			for(int j = 0; j < n; j++)
			{
				out.print((long)matr[i][j] + " ");
				crutch.writeDouble(matr[i][j]);
				oute.write(" ");
			}
		}	
		System.out.println();
		oute.close();
		crutch.close();
	}
	
	
	//initialize arrays
	public double[][] fillMatrix (double[][] matr1, int n) throws FileNotFoundException{
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++){
					in.nextDouble();
			}
		return matr1;
	}
	
	
	//IT WORKS VERY WELL!!!  HOW DO CORRECT FILE INPUT?
	/*
	 * @SupperessWarnings("resource") inner is never closed. Otherwise can not input the second matrix 
	 */
	public double[][] fillMatrix1 (double[][] matr1, int n){
		@SuppressWarnings("resource")
		Scanner inner = new Scanner(System.in);
		for (int i=0; i < n; i++)
			for (int j = 0; j < n; j++)
				matr1[i][j]=inner.nextDouble();
		
		return matr1;
	}
	
	public double[][] randomize(double[][] matr, int n){
		Random myRand = new Random();
		double cell = Math.random();
		long temp = Math.round(cell);
		myRand.setSeed(temp);
		for (int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				matr[i][j] = myRand.nextDouble();
		
		return matr;
	}
	
	public int getSize(){
		return n;
	}
	
	
}
