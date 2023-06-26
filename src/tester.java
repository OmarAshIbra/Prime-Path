
public class tester {
	public static void main(String[] args) {
	    
		System.out.print("8 nodes without loops:\n ");
	    // Creating and populating a graph object with 8 nodes without loops 
	    theGraph<Integer> graph = new theGraph<Integer>();
	    graph.Graph(8);
	    graph.link(1, 2);
	    graph.link(1, 3);
	    graph.link(2, 4);
	    graph.link(3, 4);
	    graph.link(3, 5);
	    graph.link(4, 6);
	    graph.link(4, 7);
	    graph.link(5, 6);
	    graph.link(6, 8);
	    graph.link(7, 8);
	    graph.heads.add(graph.nodes.get(0)); // 1
	    graph.tails.add(graph.nodes.get(7)); // 8
	    
	    // Find all prime paths in the graph
	    graph.findPrimePaths();
	    System.out.print("\n ");
	    
	    System.out.print("5 nodes without loops: \n");
	    // Creating and populating another graph object with 7 nodes
	    theGraph<Integer> graph2 = new theGraph<Integer>();
	    graph2.Graph(5);
	    graph2.link(1, 2);
        graph2.link(1, 3);
        graph2.link(2, 4);
        graph2.link(3, 4);
        graph2.link(4, 5);
	    graph2.heads.add(graph2.nodes.get(0));// 1
	    graph2.tails.add(graph2.nodes.get(4)); // 5
	    
	    // Find all prime paths in the second graph
	    graph2.findPrimePaths();
	    
	    System.out.print("\n ");
	    
	    
	    System.out.print("8 nodes with loops: \n");
	    
	    theGraph<Integer> graph3 = new theGraph<Integer>();
	    graph3.Graph(8);

	    // Create links between the nodes
	    graph3.link(1, 2);
	    graph3.link(1, 3);
	    graph3.link(2, 4);
	    graph3.link(3, 4);
	    graph3.link(3, 5);
	    graph3.link(4, 6);
	    graph3.link(4, 7);
	    graph3.link(5, 6);
	    graph3.link(6, 8);
	    graph3.link(7, 8);
	    graph3.link(8, 2); // add a loop between nodes 8 and 2
	    graph3.heads.add(graph3.nodes.get(0));// 1
	    graph3.tails.add(graph3.nodes.get(7)); // 8

	    // Print all the nodes in the graph
	    graph3.printAll();

	    // Find all prime paths in the graph
	    graph3.findPrimePaths();
	    
	}
	
}
