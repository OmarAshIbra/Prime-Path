import java.util.ArrayList;
import java.util.HashSet;

public class theGraph<T> {
    // Declare three ArrayList objects to store Nodes, heads, and tails
    ArrayList<Nodes<T>> nodes = new ArrayList<Nodes<T>>();
    ArrayList<Nodes<T>> heads = new ArrayList<Nodes<T>>();
    ArrayList<Nodes<T>> tails = new ArrayList<Nodes<T>>();

    // Constructor for Graph objects that takes an integer parameter called numberOfNode
    public void Graph(int numberOfNode) {
        // Create a new Nodes object for each Nodes in the graph and add it to the Nodes ArrayList
        for (int i = 0; i < numberOfNode; i++) {
        	nodes.add(new Nodes<T>((T) (Integer.valueOf(i + 1))));
        }

        // Print the info value of each Nodes in the Nodes ArrayList
        for (Nodes<T> x : nodes) {
            System.out.println(x.info);
        }
    }

    // Create a link between two Nodes in the graph
    public void link(int from, int to) {
        // Convert the indices to zero-based indexing
        from = from - 1;
        to = to - 1;
        // Add the "to" Nodes to the "next" ArrayList of the "from" Nodes
        nodes.get(from).next.add(nodes.get(to));
    }

    // Print all the Nodes  in the graph
    public void printAll() {
        for (Nodes<T> theNode : nodes) {
            System.out.print(theNode.info + ": ");
            for (Nodes<T> next : theNode.next) {
                System.out.print(next.info + " ");
            }
            System.out.print("/n");
        }
    }

    // Find all the prime paths in the graph
    public void findPrimePaths() {
        // Create a HashSet object to store all the unique paths
        HashSet<ArrayList<Nodes<T>>> allPaths = new HashSet<ArrayList<Nodes<T>>>();
        // Iterate over all possible pairs of head and tail Nodes
        for (Nodes<T> head : heads) {
            for (Nodes<T> tail : tails) {
                // Create a new ArrayList object to store the current path and add the head Nodes to it
                ArrayList<Nodes<T>> path = new ArrayList<Nodes<T>>();
                path.add(head);
                // Create a HashSet object to store the Nodes that have been visited
                HashSet<Nodes<T>> visited = new HashSet<Nodes<T>>();
                visited.add(head);
                // Recursively find all paths from the head Nodes to the tail Nodes
                findPathsHelper(head, tail, allPaths, path, visited);
            }
        }
        // Print all the prime paths
        System.out.println("All prime paths: ");
        for (ArrayList<Nodes<T>> path : allPaths) {
            System.out.print(path.get(0).info);
            for (int i = 1; i < path.size(); i++) {
                System.out.print(" -> " + path.get(i).info);
            }
            System.out.println();
        }
    }

    // Helper method to find all paths from the current Nodes to the target Nodes
    private void findPathsHelper(Nodes<T> current, Nodes<T> target, HashSet<ArrayList<Nodes<T>>> allPaths,
                                 ArrayList<Nodes<T>> path, HashSet<Nodes<T>> visited) {
        // If the current Nodes is the target Nodes, add the current path to the HashSet of all paths
        if (current == target) {
            if (isPrimePath(path)) {
                allPaths.add(path);
            }
            return;
        }
        // Recursively explore all unvisited next Nodes
        for (Nodes<T> next : current.next) {
        	 if (!visited.contains(next)) {
                 ArrayList<Nodes<T>> newPath = new ArrayList<Nodes<T>>(path);
                 newPath.add(next);
                 HashSet<Nodes<T>> newVisited = new HashSet<Nodes<T>>(visited);
                 newVisited.add(next);
                 findPathsHelper(next, target, allPaths, newPath, newVisited);
             }
         }
     }

     private boolean isPrimePath(ArrayList<Nodes<T>> path) {
         // A path is prime if it does not contain any repeated nodes
         HashSet<Nodes<T>> NodesInPath = new HashSet<Nodes<T>>();
         for (Nodes<T> node : path) {
             if (NodesInPath.contains(node)) {
                 return false;}}
 		return true;
             
             }}