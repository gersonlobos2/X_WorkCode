import simulation.Graph;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g= new Graph(7);
		
		g.setLabel(0, "v0");
		g.setLabel(1, "v1");
		g.setLabel(2, "v2");
		g.setLabel(3, "v3");
		g.setLabel(4, "v4");
		g.setLabel(5, "v5");
		g.setLabel(6, "v6");
		
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 4);
		g.addEdge(1, 3);
		g.addEdge(3, 5);
		g.addEdge(3, 6);
		g.addEdge(3, 0);
		g.addEdge(2, 4);
		g.addEdge(4, 2);
		g.addEdge(6, 1);
		
		g.depthFirstPrint(g, 0);
		
		System.out.println("");
		g.BreathFirstPrint(g, 0);
		
	}

}
