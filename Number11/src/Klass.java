import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Klass {
	static Map<String, Integer> exam = new HashMap<String, Integer>();

	public static void createHash(File file) throws IOException {
		StringBuilder nkey = new StringBuilder(" ");

		BufferedReader in = new BufferedReader(new FileReader(file));

		while (in.ready()) {
			char ch = (char) in.read();
			if (((ch >= 'A') && (ch <= 'Z')) || ((ch >= 'a') && (ch <= 'z'))) {
				nkey.append(ch);
			} else {
				char ex = ' ';
				ex = nkey.charAt(nkey.length() - 1);
				
				if (((ex >= 'A') && (ex <= 'Z')) || ((ex >= 'a') && (ex <= 'z'))) {
					String temp = nkey.toString().toLowerCase();
					if (exam.containsKey(temp)) {
						exam.put(temp.toString(), exam.get(temp) + 1);
					} else {
						exam.put(temp.toString(), 1);
					}
				}
				nkey = new StringBuilder(" ");
			}
		}
		in.close();
		System.out.println("la la ta la la la");
		
	}
}
