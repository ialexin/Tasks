import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Mainful {

	public static void main(String[] args) throws IOException {
		System.out.println("******Reading from file 'data'******");
		File file = new File("data");
		
		Scanner in = new Scanner(file);
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.clear();
        
        int k = in.nextInt() - 1;
        Realise obj = new Realise();
        System.out.println("\nFind the " + (k + 1) + obj.ending(k + 1) + " element in increasing order");
     
        while (in.hasNextInt()){
            list.add(in.nextInt());
        }
        System.out.println("\n\nInput data: " + list.toString());
        int ans = obj.orderStat(list, 0, list.size() - 1, k);
        
        System.out.println("\nThe answer is: " + ans);
        in.close();
	}

}
