package org.eda1.actividad04;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ManageFloyd extends Network<String> {

	private enum Secciones{
		TIPO,
		VERTEX,
		EDGES;

		void insertar (ManageFloyd mF, String line){
			switch(this){
			case TIPO:
					mF.setDirected(line.toLowerCase().equals("directed") ? true : false);
					break;
			case VERTEX:
					mF.addVertex(line);
					mF.vertexToIndex.put(line, mF.vertexToIndex.size());
					break;
			case EDGES:
					String[] words = line.split(" ");
					mF.addEdge(words[0], words[1], Double.parseDouble(words[2]));
					break;
			}
		}
	}

	public ManageFloyd(String filename){
		super();
		loadNetwork(filename);
		floyd();
	}

	private void loadNetwork(String filename){
		String line = "";
		Scanner scan = null;
		Secciones seccion = null;

		this.adjacencyMap.clear();
		this.vertexToIndex.clear();

		try{
			scan = new Scanner(new File(filename));
		}catch(Exception e){
			System.out.println("Error al cargar el archivo --> " + e.getMessage());
			System.exit(-1);
		}

		while(scan.hasNextLine()){
			line = scan.nextLine();
			if (line.isEmpty()) continue;
			if (line.startsWith("%")) continue;
			if (line.toLowerCase().contains("@vertex")){
				seccion = Secciones.VERTEX;
				continue;
			}
			if (line.toLowerCase().contains("@edges")){
				seccion = Secciones.EDGES;
				continue;
			}
			if (line.toLowerCase().contains("@type")){
				seccion = Secciones.TIPO;
				continue;
			}
			seccion.insertar(this, line);
		}
	}

	public TreeMap<String, Integer> getVertexToIndex(){
		return this.vertexToIndex;
	}

	public String getVertexFromIndex(int index) {
		String v = null;
		for (Map.Entry<String, Integer> e : vertexToIndex.entrySet()) {
			if (e.getValue() != index)
				continue;
			v = e.getKey();
			break;
		}
		return v;
	}

	public int[][] getMatrixA(){
		return matrixA;
	}

	public double[][] getMatrixD(){
		return matrixD;
	}

	public ArrayList<String> getPaths() {
		ArrayList<String> resultado = new ArrayList<String>();
		int numPaths = 1;
		for (int i = 0; i < this.vertexToIndex.size(); i++) {
			for (int j = 0; j < this.vertexToIndex.size(); j++) {
				if (i == j)
					continue;
				if (matrixD[i][j] == Double.MAX_VALUE)
					continue;
				resultado.add("Camino #" + (numPaths++) + ": " + findPath(i, j) + " (" + matrixD[i][j] + ")");
			}
		}

		return resultado;
	}

	public String findPath(String vertexI, String vertexJ) {
		int vI, vJ;
		if (!vertexToIndex.containsKey(vertexI) || !vertexToIndex.containsKey(vertexJ))
			return null;
		if (vertexI.equals(vertexJ))
			return "Just the same vertex...";
		vI = vertexToIndex.get(vertexI);
		vJ = vertexToIndex.get(vertexJ);
		if (matrixD[vI][vJ] == Double.MAX_VALUE)
			return null;
		return findPath(vI, vJ) + " (" + matrixD[vI][vJ] + ")";
	}

	private String findPath(int vertexI, int vertexJ) {
		ArrayList<String> camino = new ArrayList<String>();
		String resultado = "";
		findPathAux(vertexI, vertexJ, camino);
		if (camino.isEmpty())
			return "";
		resultado = camino.get(0).toString();
		for (int i = 1; i < camino.size(); i++) {
			if (camino.get(i) != camino.get(i - 1)) {
				resultado += " --> " + camino.get(i).toString();
			}
		}
		return resultado;
	}

	private void findPathAux(int vertexI, int vertexJ, ArrayList<String> camino) {
		//...
	}

	public ArrayList<String> filterPathsByDistance(double distanceMin, double distanceMax) {
		//...
	}

	public String findTheLargestPath() {
		//...
	}

	public String findTheShortestPath() {
		//...
	}

}
