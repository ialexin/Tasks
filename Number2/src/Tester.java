import java.util.ArrayList;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class Tester {
	@Test
	public void Checker1(){
		ArrayList<Integer> exam = new ArrayList<Integer>();
		exam.clear();
		
		exam.add(15);
		exam.add(7);
		exam.add(23);
		exam.add(19);
		exam.add(98);
		exam.add(21);
		exam.add(11);
		exam.add(12);
		exam.add(8);
		exam.add(37);
		
		int position = 5;
		int result = 15;
		
		Realise obj = new Realise();
		int answer = obj.orderStat(exam, 0, exam.size() - 1, position - 1);

		Assert.assertEquals(result, answer);
	}
	
	@Test 
	public void Checker2(){
		ArrayList<Integer> exam = new ArrayList<Integer>();
		exam.clear();
	
		
		exam.add(46);
		exam.add(3);
		exam.add(29);
		exam.add(75);
		exam.add(59);
		exam.add(91);
		exam.add(17);
		exam.add(13);
		exam.add(8);
		exam.add(11);
		
		int position = 7;
		int result = 46;
		
		Realise obj = new Realise();
		int answer = obj.orderStat(exam, 0, exam.size() - 1, position - 1);

		Assert.assertEquals(result, answer);
	}
}
