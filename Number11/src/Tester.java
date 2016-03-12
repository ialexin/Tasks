import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;

public class Tester {

	@Test
	public void test1() throws IOException {
		File file = new File("test1");
		Klass.createHash(file);
		Set<Entry<String, Integer>> set = Klass.exam.entrySet();
		
		for (Map.Entry<String, Integer> me : set) {
			System.out.println(me.getKey() + " be found " + me.getValue() + " times ");
		}
		
		String res = set.toString();
		System.out.println("result is: " + res);
		
		String expect = "[ a=3,  the=1,  piper=4,  peppers=4,  of=4,  peter=4,  peck=4,  is=1,  pickled=4,  picked=4,  if=1,  where=1]";
		Assert.assertEquals(expect, res);
		
	}
}
