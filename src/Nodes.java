import java.util.ArrayList;

public class Nodes<T> {
	
	// Declare a public Nodes object called prev to store the previous node in the list
	public Nodes<T> prev; 
	
	// Declare a public variable called info of type T to store the data value of this node
	public T info;
	
	// Declare a public ArrayList object called next to store the next nodes in the list
	// This ArrayList is initialized to an empty list
	public ArrayList<Nodes<T>> next = new ArrayList<Nodes<T>>();
	
	// Constructor for Nodes objects that takes a parameter of type T called el
	public Nodes(T el) {
		// Set the info variable of this node to the value of el
		info = el;
	}
}

