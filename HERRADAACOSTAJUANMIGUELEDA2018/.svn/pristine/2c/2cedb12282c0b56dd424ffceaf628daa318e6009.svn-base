package org.eda1.caso06;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Set;
import org.eda1.edaAuxiliar.Graph;


public class Network<Vertex extends Comparable<Vertex>> implements Graph<Vertex>, Iterable<Vertex> {

	private boolean directed; 	// directed = false (unDirected), directed = true (DiGraph)

	private TreeMap<Vertex, TreeMap<Vertex, Double>> adjacencyMap;

	public Network(){
		directed = true;
		adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();
	}

   	public Network(boolean uDOrD) { //uDOrD == unDirected Or Directed
  		directed = uDOrD;
		adjacencyMap = new TreeMap<Vertex, TreeMap<Vertex, Double>>();
	}

  	public void setDirected(boolean uDOrD) {
  		directed = uDOrD;
  	}

  	public boolean getDirected() {
  		return directed;
  	}

  	@Override
  	public boolean isEmpty() {
    	return adjacencyMap.isEmpty();
  	}

  	@Override
  	public void clear() {
		adjacencyMap.clear();
	}

  	@Override
  	public int numberOfVertices() {
    	return adjacencyMap.size();
  	}

  	@Override
  	public int numberOfEdges() {
  		int count = 0;
  		for (TreeMap<Vertex, Double> itMap : adjacencyMap.values())
  			count += itMap.size();
  		return count;
  	}

  	@Override
  	public boolean containsVertex(Vertex vertex) {
    	return adjacencyMap.containsKey(vertex);
  	}

  	@Override
  	public boolean containsEdge(Vertex v1, Vertex v2) {
    	return adjacencyMap.containsKey(v1) && adjacencyMap.get(v1).containsKey(v2);
  	}

  	@Override
  	public double getWeight (Vertex v1, Vertex v2) {
  		if (!containsEdge(v1, v2)) return -1;
  		return adjacencyMap.get(v1).get(v2);
   	}

  	@Override
  	public double setWeight (Vertex v1, Vertex v2, double w) {
  		if (!containsEdge(v1, v2)) return -1;
		double oldWeight = adjacencyMap.get(v1).get(v2);
		adjacencyMap.get(v1).put(v2, w);
		return oldWeight;
	}

  	public boolean isAdjacent (Vertex v1, Vertex v2) {
		return (adjacencyMap.containsKey(v1) && adjacencyMap.get(v1).containsKey(v2));

	}

  	public boolean addVertex(Vertex vertex) {
        if (adjacencyMap.containsKey(vertex))   return false;
        adjacencyMap.put(vertex, new TreeMap<Vertex, Double>());
        return true;
  	}

  	public boolean addEdge(Vertex v1, Vertex v2, double w) {
  		if (!containsVertex(v1) || !containsVertex(v2)) return false;
  		adjacencyMap.get(v1).put(v2, w);

    	if (!directed)
        	adjacencyMap.get(v2).put(v1, w);

    	return true;
  	}

  	public boolean removeVertex(Vertex vertex) {
        if (!containsVertex(vertex)) return false;

        for (TreeMap<Vertex, Double> itMap: adjacencyMap.values()) {
        	itMap.remove(vertex);
        }
        adjacencyMap.remove(vertex);
        return true;
   	}

  	public boolean removeEdge (Vertex v1, Vertex v2) {
    	if (!containsEdge(v1,v2)) return false;

    	adjacencyMap.get(v1).remove(v2);

    	if (!directed) {
        	adjacencyMap.get(v2).remove(v1);
    	}

    	return true;
  	}

  	public Set<Vertex> vertexSet() {
    	return adjacencyMap.keySet();
  	}

  	/**
  	 *  Returns a LinkedList object of the neighbors of a specified Vertex object.
  	 *
  	 *  @param v - the Vertex object whose neighbors are returned.
  	 *
  	 *  @return a LinkedList of the vertices that are neighbors of v.
   	 */

  	public TreeSet<Vertex> getNeighbors(Vertex v) {
    	if (adjacencyMap.containsKey(v)) return null;
    	return (TreeSet<Vertex>) adjacencyMap.get(v).keySet();
  	}

  	@Override
  	public String toString() {
    	return adjacencyMap.toString();
  	}


	/////////Dijkstra

	public ArrayList<Vertex> Dijkstra(Vertex source, Vertex destination) {
  		final double INFINITY = Double.MAX_VALUE;
  		
  		Double weight = .0, minWeight = INFINITY;
    	TreeMap<Vertex, Double> D = new TreeMap<Vertex, Double>();
    	TreeMap<Vertex, Vertex> S = new TreeMap<Vertex, Vertex>();
    	TreeSet<Vertex> V_minus_S = new TreeSet<Vertex>();

    	ArrayList<Vertex> path = new ArrayList<Vertex>();
    	//ALStack<Vertex> st = new ALStack<Vertex>();
		ArrayDeque<Vertex> st = new ArrayDeque<Vertex>();
    	Vertex from = null;

    	if (source == null || destination == null) return null;

    	if (source.equals(destination))	return null;

    	if (!(adjacencyMap.containsKey(source) && adjacencyMap.containsKey(destination))) return null;

    	// Este es el codigo que hay que modificar para la realizacion del caso05...
    	
    	for (Vertex e : this.adjacencyMap.keySet()) {
    		if(e.equals(source)){
    			source = (Vertex) e;
    		}
    		if(e.equals(destination)){
    			destination = (Vertex) e;
    		}
    		V_minus_S.add(e);
    	}
    	//Fin de la modificacion


    	for (Vertex v : V_minus_S){
    		if (isAdjacent(source,v)){
    			S.put(v, source);
    			D.put(v, getWeight(source,v));
    		}
    		else{
    			S.put(v, null);
    			D.put(v, INFINITY);
    		}
    	}

		S.put(source, source);
		D.put(source, 0.0);

		while (!V_minus_S.isEmpty()) {
		    minWeight = INFINITY;
		    from = null;
		    for (Vertex v : V_minus_S){
		    	if (D.get(v) < minWeight){
		    		minWeight = D.get(v);
		    		from = v;
		    	}
		    }
	    	if (from == null) break;

			V_minus_S.remove(from);

		    for (Vertex v : V_minus_S){
		    	if (isAdjacent(from,v)){
		    		weight = getWeight(from,v);
		    		if (D.get(from) + weight < D.get(v)){
		    			D.put(v, D.get(from) + weight);
		    			S.put(v, from);
		    		}
		    	}
		    }
		}


		if (S.get(destination) == null) {
			throw new RuntimeException("The vertex " + destination + " is not reachable from " + source);
		}

		st.push(destination);
		while (!st.peek().equals(source)) {
			st.push(S.get(st.peek()));
		}
		while (!st.isEmpty()) {
			path.add(st.peek());
			st.pop();
		}
		return path;
	}

	//

	public double computeDistanceFromPath(ArrayList<Vertex> path){
		double result=.0;
		for (int i=1; i<path.size(); i++){
			result += this.getWeight(path.get(i-1), path.get(i));
		}
		return result;
	}

  	////Iterators

	@Override
	public Iterator<Vertex> iterator() { //Iterador sobre el conjunto de claves --> orden lexicografico
        return adjacencyMap.keySet().iterator();
  	}


  	public BreadthFirstIterator breadthFirstIterator (Vertex v) { //Iterador en anchura a partir de v
    	if (!adjacencyMap.containsKey(v)) return null;
    	return new BreadthFirstIterator(v);
  	}


  	public DepthFirstIterator depthFirstIterator (Vertex v) { //Iterador en profundidad a partir de v
    	if (!adjacencyMap.containsKey (v)) return null;
    	return new DepthFirstIterator(v);
  	}

  	//toArray() methods

  	public ArrayList<Vertex> toArrayDFRecursive(Vertex start) {
		ArrayList<Vertex> result = new ArrayList<Vertex>();

		TreeMap<Vertex,Boolean> visited = new TreeMap<Vertex, Boolean>();

		for (Vertex v : adjacencyMap.keySet()){
			visited.put(v,false);
		}

		toArrayDFAux(start, result, visited);

		return result;
	}

	private void toArrayDFAux(Vertex current, ArrayList<Vertex> result, TreeMap<Vertex,Boolean> visited) {
		result.add(current);
		visited.put(current, true);
		for (Vertex to : adjacencyMap.get(current).keySet()) {
			if (!visited.get(to))
				toArrayDFAux(to,result,visited);
		}
	}

	public ArrayList<Vertex> toArrayDF(Vertex start) {
		ArrayList<Vertex> result = new ArrayList<Vertex>();
		for (Vertex v: this.depthFirstIterator(start)){
			result.add(v);
		}
		return result;
	}

	public ArrayList<Vertex> toArrayBF(Vertex start) {
		ArrayList<Vertex> result = new ArrayList<Vertex>();
		for (Vertex v : this.breadthFirstIterator(start)){
			result.add(v);
		}
		return result;
	}

  	protected class BreadthFirstIterator implements Iterator<Vertex>, Iterable<Vertex> {
    		protected LinkedList<Vertex> queue;

    		protected TreeMap<Vertex, Boolean> visited;

    		protected Vertex current;

    		public BreadthFirstIterator (Vertex start)
    		{
      			queue = new LinkedList<Vertex>();

      			visited = new TreeMap<Vertex, Boolean>();

      			for (Vertex v : adjacencyMap.keySet()){
      				visited.put(v,false);
      			}

      			queue.add(start);
      			visited.put (start, true);
    		} // one-parameter constructor


    		public boolean hasNext()
    		{
      			return !(queue.isEmpty());
    		} // method hasNext


    		public Vertex next()
    		{
      			current = queue.poll();

            	for (Vertex to : adjacencyMap.get(current).keySet()) {
        			if (!visited.get(to))
        			{
          				visited.put (to, true);
          				queue.add(to);
        			}
      			}
      			return current;
    		} // method next


    		public void remove()
    		{
      			removeVertex (current);
    		} // method remove


			@Override
			public Iterator<Vertex> iterator() {
				return this;
			}

  	} // class BreadthFirstIterator


  	protected class DepthFirstIterator implements Iterator<Vertex>, Iterable<Vertex>{

    		ArrayDeque<Vertex> stack;

    		TreeMap<Vertex, Boolean> visited;

    		Vertex current;


    		public DepthFirstIterator (Vertex start)
    		{
      			stack = new ArrayDeque<Vertex>();

      			visited = new TreeMap<Vertex, Boolean>();

      			for (Vertex v : adjacencyMap.keySet()){
      				visited.put(v, false);
      			}

      			stack.push (start);
      			visited.put (start, true);
    		} // one-parameter constructor


    		public boolean hasNext()
    		{
      			return !(stack.isEmpty());
    		} // method hasNext


    		public Vertex next()
    		{
      			current = stack.pop();

                for (Vertex to: adjacencyMap.get(current).keySet()) {
        			if (!visited.get (to))
        			{
          				visited.put (to, true);
          				stack.push (to);
        			}
      			}
      			return current;
    		}

    		public void remove()
    		{
      			removeVertex (current);
    		}

			@Override
			public Iterator<Vertex> iterator() {
				return this;
			}

  	} // class DepthFirstIterator

} // class Network
