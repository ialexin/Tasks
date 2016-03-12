import java.io.*;
import java.util.Map;
import java.util.Set;


public class Hash {
	public static void main(String[] args) throws IOException {
		File file = new File("data");
		Klass.createHash(file);
		Set <Map.Entry<String, Integer>> set = Klass.exam.entrySet();
		
		for(Map.Entry<String, Integer> me: set){
				System.out.println(me.getKey() + " be found " + me.getValue() + " times ");
		}
	}
	
}