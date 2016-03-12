package alexin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Graf {
		ArrayList<Integer>[] graph;
		boolean[] visited;
		Stack<Edge> stack;
		int time;
		int[] enter;
		int[] lowlink;
		private ArrayList<ArrayList<Edge>> components;
		private ArrayList<Integer> cutPoints;
		private ArrayList<String> bridges;
		
		@SuppressWarnings("unchecked")
		public Graf(int N) {
			graph = new ArrayList[N];
			for (int i = 0; i < N; i++){
				graph[i] = new ArrayList<Integer>();
			}
			visited = new boolean [N];
			time = 0;
			enter = new int[N];
			lowlink = new int[N];
			stack = new Stack<>();
			components = new ArrayList<ArrayList<Edge>>();
			cutPoints = new ArrayList<Integer>();
			bridges = new ArrayList<String>();
		}

		public Graf(Scanner in) {
			this(in.nextInt());
			while(in.hasNextInt()){
				int v1 = in.nextInt();
				int v2 = in.nextInt();
				addEdge(v1, v2);
			}
		}
		
		public void addEdge(int v1, int v2) {
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		
		@Override
		public String toString(){
			StringBuilder str = new StringBuilder();
			for(int i = 0; i < graph.length; i++){
				Iterator<Integer> iter = graph[i].iterator();
				while(iter.hasNext()){
					str.append(i).append("-->").append(iter.next()).append("\n");
				}
			}
			return str.toString();
		}
		
		
		
		public void biconComponents(){
			for (int v = 0; v < graph.length; v++){
				if (!visited[v]){
					DFS(v, -1);
				}
			}
			for (int i = components.size() - 1; i >= 0; i--){
				if(components.get(i).size() < 2){
					components.remove(i);
				}
			}
			System.out.println("BiconComponents");
			System.out.println(components.toString());
			
			System.out.println("CutPoints");
			System.out.println(cutPoints.toString());
			
			System.out.println("Bridges:");
			System.out.println(bridges.toString());
		}
		
		public void bridges(){
			
		}
		
		public ArrayList<ArrayList<Edge>> getComponents(){
			return components;
		}
		
		public ArrayList<Integer> getcutPoints(){
			return cutPoints;
		}
		
		public ArrayList<String> getBridges(){
			return bridges;
		}
		
		private void DFS(int u, int p){
			visited[u] = true;
			time++;
			enter[u] = time; //время начала обработки
			/*
			 * Определим числовую функцию lowlink на множестве вершин следующим образом:
			 * рассмотрим в дереве Gp(граф поиска в глубину) поддерево с корнем в u
			 */
			lowlink[u] = time; //минимальное значение enter[v], где v пробегает пробегает множество
			//концов всех обратных ребёр  с началом в этом поддереве, а также саму вершину u
			int children = 0;
			boolean cutPoint = false;
			for(int v : graph[u]){
				if( v == p)
					continue;
				stack.push(new Edge(v,u));
				if(visited[v]){
					lowlink[u] = Math.min(lowlink[u],  enter[v]);
				}
				else{
					DFS(v, u);
					lowlink[u] = Math.min(lowlink[u],  lowlink[v]);
					cutPoint = lowlink[v] >= enter[u] || (p == -1 && children > 1);
					children++;
					
					if (cutPoint) {
						if(lowlink[u] == enter[u]){
							ArrayList<Edge> component = new ArrayList<Edge>();
							Edge e;
							do {
								e = stack.pop();
								component.add(e);
							} while (e.vertex1 == v && e.vertex2 == u);
							if (component.size() > 1) {
								components.add(component);
							} else {
								bridges.add(e.toString());
							}
						}
					}
				}
			}
		}
	}

