import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		File file = new File("input");
		TreeSet<Double> data = new TreeSet<Double>();
		Scanner in = new Scanner(file);

		boolean flag = true;

		double D = in.nextDouble();
		data.add(in.nextDouble());
		while (flag) {
			if (in.hasNextDouble()) {
				double next = in.nextDouble();
				if ((data.lower(next) != null) && (Math.abs(data.lower(next) - next) <= D)
						|| (data.higher(next) != null) && (Math.abs(data.higher(next) - next) <= D)) {
					flag = false;
				}
				data.add(next);
			} else {
				flag = false;
			}
		}
		in.close();
		System.out.println(data.toString());
	}

}
