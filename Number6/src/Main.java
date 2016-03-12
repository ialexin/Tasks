import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		File file =  new File("data");
		Scanner in = new Scanner(file);
		Random ran = new Random();
		int N = 25;
		int[] mas = new int[N];
		
		for(int i = 0; i < N; i++){
			mas[i] = ran.nextInt(20);
		}
		int[] arr = mas.clone();
		int[] ar = mas.clone();
		System.out.println("*****Elementary QuickSort*****");
		Operation.QS(mas, 0, mas.length - 1);
		System.out.println(Arrays.toString(mas));

		System.out.println("\n\n*****One recursion sort*****");
		Realise.method(ar, 0, ar.length - 1);
		System.out.println(Arrays.toString(ar));
	}

}
