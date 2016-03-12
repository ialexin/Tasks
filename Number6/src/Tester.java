import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class Tester {
	@Test
	public void test(){
		int L = 45;
		int[]  mas = new int[L];
		Random ran = new Random();
		
		Scanner in = new Scanner(System.in);
		
		for (int i = 0; i < L; i++){
			mas[i] = ran.nextInt(25);
		}
		
		System.out.println("*******Default Array*******");
		System.out.println(Arrays.toString(mas) + "\n\n");
		
		
		int[] arr = mas.clone();
		Arrays.sort(mas);
		System.out.println(Arrays.toString(mas) + "\n");		
		
		
		System.out.println("*******Mundane Quick Sort*******");
		System.out.println(Arrays.toString(mas));
		
		
		Realise.method(arr, 0, mas.length - 1);
		System.out.println("*******One Recurison QuickSort*******");
		System.out.println(Arrays.toString(arr));
		Assert.assertArrayEquals(mas, arr);
		in.close();
		}
}
