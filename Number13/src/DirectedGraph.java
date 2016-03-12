import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DirectedGraph {
	private ArrayList<ArrayList<Integer>> adj;
	static private int[] weight;
	private final int V;
	private int E;

	public DirectedGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = new ArrayList<ArrayList<Integer>>();
		for (int v = 0; v < V; v++) {
			adj.add(new ArrayList<Integer>());
		}
		weight = new int[V];
	}

	public DirectedGraph(Scanner in) {
		this(in.nextInt());
		int E = in.nextInt();
		for (int i = 0; i < E; i++) {
			int v1 = in.nextInt();
			int v2 = in.nextInt();
			addEdge(v1, v2);
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(int v1, int v2) {
		adj(v1).add(v2);
	}

	public ArrayList<Integer> adj(int v) {
		return adj.get(v);
	}


	public void printGraph() {
		for (int v = 0; v < V; v++) {
			ArrayList<Integer> def = adj.get(v);
			Iterator<Integer> iter = def.iterator();
			if (!iter.hasNext()){
				System.out.print(v + "--> null");
			}
			else System.out.print(v);
				while (iter.hasNext()) {
					System.out.print("-->" + iter.next());
				}
				System.out.println();
			}
	}
	
	

}
