import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Mains {
	public static void main(String[] args) throws IOException {
		File file = new File("input");
		Scanner in = new Scanner(file);
		int V = in.nextInt();
		int E = in.nextInt();
		Orderer schedule = new Orderer(in, V, E);
	        for(int i = 0; i < V; i++) {
	            schedule.dfs(i);
	        }
	    int weight = 0;
	    System.out.println("\n\nOptimal schedule:\n");
	    while (!schedule.stack.isEmpty()){
	    	int next = schedule.stack.pop();
	    	System.out.println("Num of prob: " + next + " *** Time of start solving: " + weight);	
	    	weight += schedule.weights[next];
	    }
	    int sum = 0;
	  
	    for (int i = 0; i < schedule.weights.length; i++){
	    	sum +=schedule.weights[i];
	    }
	    System.out.println(sum);
	}
}
