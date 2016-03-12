import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Orderer {
	ArrayList<Integer>[] graph;
    boolean[] marked;
    boolean[] inQueue;
    int[] weights;
    Stack<Integer> stack;
	
	@SuppressWarnings("unchecked")
	public Orderer(Scanner in, int N, int E ){
		graph = new ArrayList[N];
		inQueue = new boolean[N];
		marked = new boolean[N];
		weights = new int[N];
		
		for(int i = 0; i < N; i ++){
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < E; i++){
			int v1 = in.nextInt();
			int v2 = in.nextInt();
			this.addEdge(v1, v2);
		}
		for (int i = 0; i < N; i++){
			int a = in.nextInt();
			System.out.println(i + " weight:" + a);
			this.weights[i] = a;
		}
		stack = new Stack<Integer>();
		}
		
		
	public void addEdge(int v1, int v2) {
		graph[v1].add(v2);
	}
	
	public void dfs(int pos) {
		this.marked[pos] = true;
		for (int next : this.graph[pos]) {
			Iterator<Integer> iter = this.graph[pos].iterator();
			while (iter.hasNext()) {
				int w = iter.next();
				if (!this.marked[w]) {
					dfs(next);
				}
			}
		}
		if (!inQueue[pos]) {
			inQueue[pos] = true;
			stack.push(pos);
		}
	}
}
