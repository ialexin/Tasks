import java.util.HashSet;

import alexin.Edge;

public class Graph {
	static HashSet <Edge> edges; 
	
	public Graph(){
		edges = new HashSet<Edge>();
		edges.clear();
	}
	
	public void add(int vertex1, int vertex2){
		Edge edge = new Edge(vertex1, vertex2);
		edges.add(edge);
	}
	
	public boolean remove(int vert1, int vert2){
		Edge edge = new Edge(vert1, vert2);
		return edges.remove(edge);
	}
	
	 @Override
	public String toString() {
		StringBuilder str = new StringBuilder();
				for(Edge e: edges){
						str.append(e.toString() + "\n");
						}
		return str.toString();
	}
}
