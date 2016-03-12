import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		 System.out.print("Input expression in prefix form: ");
		 
         TreeElement root = TreeElement.readTreeElement(new BufferedReader(
                 new InputStreamReader(System.in)));
         System.out.print("Result is : ");
         System.out.print(root.toInfix());
	}
}

