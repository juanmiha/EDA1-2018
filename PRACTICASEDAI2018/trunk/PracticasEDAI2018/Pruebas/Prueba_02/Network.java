package org.eda1.prueba02;

import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;
import org.eda1.edaAuxiliar.Graph;


public class Network<Vertex extends Comparable<Vertex>> implements Graph<Vertex> {

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
  		if (!containsVertex(v1)) addVertex(v1);
  		if (!containsVertex(v2)) addVertex(v2);
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
	
  	public TreeSet<Vertex> vertexSet() {
    	return new TreeSet<Vertex> (adjacencyMap.keySet());
  	}

   	public TreeSet<Vertex> getNeighbors(Vertex v) {
    	if (!adjacencyMap.containsKey(v)) return null;
    	return new TreeSet<Vertex>(adjacencyMap.get(v).keySet());
  	}

  	@Override
  	public String toString() {
    	return adjacencyMap.toString();
  	} 

  	public String getNeighborsOfVertex(Vertex v){
		TreeMap<String, Double> reducedAdjacencyMap = null;
		
		//Se trata de obtener el conjunto de vertices adyacentes a v, pero con un formato especifico
		//Para temas de formato, consultar el Test
		
		return reducedAdjacencyMap.toString();
  	}
  
} // class Network
