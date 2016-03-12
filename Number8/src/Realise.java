import java.io.BufferedReader;
import java.io.IOException;

public class Realise {
	public TreeElement readTreeElement(BufferedReader in) throws IOException {
		char ch = (char) in.read();
		if ((ch != '*') && (ch != '/') && (ch != '-') && (ch != '+')) {
			return new TreeElement(ch, null, null);
		} else {
			return new TreeElement(ch, readTreeElement(in), readTreeElement(in));
		}
	}
	
	
}
