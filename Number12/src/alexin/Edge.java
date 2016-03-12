package alexin;

public class Edge {
	public int vertex1;
	public int vertex2;
	
	public Edge(int v1, int v2){
		vertex1 = Math.min(v1, v2);
		vertex2 = Math.max(v1, v2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		return ((vertex1 == other.vertex1) && (vertex2 == other.vertex2))
				|| ((vertex1 == other.vertex2) && (vertex2 == other.vertex1));
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		int vertex = vertex1 + vertex2;
		result = prime * result + vertex;
		return result;
	}
	
	@Override 
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append(" (" + vertex1 + "<->" + vertex2 + ") ");
		return str.toString();
	}
}
