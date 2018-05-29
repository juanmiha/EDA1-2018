package org.eda1.practica02.ejercicio03;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

import org.eda1.edaAuxiliar.AVLTree;

import java.io.File;
import java.io.IOException;

public class CorrectorOrtografico {

	private AVLTree<String> treePalabras;

	public CorrectorOrtografico() {
		treePalabras = new AVLTree<String>();
	}

	public void loadFile(String archivo) {
		Scanner scan = null;
		String linea;
		try {
			treePalabras.clear();
			scan = new Scanner(new File(archivo));
			while (scan.hasNextLine()) {
				linea = scan.nextLine();
				if (linea.isEmpty()) continue;
				treePalabras.add(linea);
			}
			scan.close();
			}
			catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}

	public  ArrayList<String> listaSugerencias(int n, String s) {
	    ArrayList<String> listaSugerencias = new ArrayList<String>();
	    PriorityQueue<PalabraDistancia> palabrasSugeridas = new PriorityQueue<PalabraDistancia>();
		int distancia;
	    for(String aux:treePalabras){
	    	distancia = ComputoDistancia.computeLevenshteinDistance(aux,s);
	    	palabrasSugeridas.add(new PalabraDistancia(aux,distancia));
	    }
	    for(int i = 0;i < n;i++){
	    	listaSugerencias.add(palabrasSugeridas.poll().getPalabra());
	    }
	    return listaSugerencias;
	}

	public boolean add(String palabra){
		return this.treePalabras.add(palabra);
	}

	public boolean containsPalabra(String palabra){
		return treePalabras.contains(palabra);
	}

	public int size() {
		return treePalabras.size();
	}

	public String find(String palabra) {
		return treePalabras.find(palabra);
	}
}
