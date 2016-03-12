import java.util.ArrayList;

public class Realise {
	
	static int n;
	
	/**
	 * do bit reverse in array's indexes with bit operations  and 
	 * then swap value of default index with value of reversed index
	 * 
	 * @include private method swapElements   
	 * @param mas - data
	 * @return array with swapped elements 
	 */
	public static ArrayList<Integer>  bitReverse(ArrayList<Integer> mas){
		n = (int) (Math.log(mas.size()) / Math.log(2));
		System.out.println(n);
		for (int i = 0; i < mas.size(); i++){
			//temprorary variable which will be reversed
			int temp = i;
			//variable which keep the result of reversing
			int j = 0;
			for (int k = 0; k < n; k++){
				// current the most right bit in temp;
				int cBit = temp & 1;
				// copy cBit in j
				j <<= 1;
				j = j | cBit;
				temp >>= 1;
			}
			if (j > i){
				swapElements(mas, i, j);
			}
		}
		return mas;
	}
	
	private static void swapElements(ArrayList<Integer> mas, int i, int j){
		System.out.println(i + " (" + binar(i) + ") <--> " + j + "(" + binar(j) + ")");
		int temp = mas.get(i);
		mas.set(i, mas.get(j));
		mas.set(j, temp);
	}
	
	/*
	 * reperesent integer in binar number base. Binar number has n bits
	 * if less then write k '0' in the head of number while number  of bits != n
	 * 	 */
	private static String binar(int a){    
        int b;     
    String temp = "";    
        while(a !=0){  
        	b = a%2;  
        	temp = b + temp;  
        	a = a/2; 
        } 	
        while ( temp.length() != n)
        	temp = 0 + temp;
        return(temp);  
	}
}
