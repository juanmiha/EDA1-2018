package org.eda1.actividad03.ejercicio01;

import java.io.File;
import java.util.*;


public class SpellChecker {
	private TreeSet<String> dictionary;
	private TreeSet<String> document;


	public SpellChecker() {
		this.dictionary = new TreeSet<String>();
		this.document = new TreeSet<String>();
	}


	public void loadDictionary(String file) {
		Scanner scan = null;
		String linea;
		this.dictionary.clear();
		try{
			scan = new Scanner(new File(file));
		}catch(Exception e){
			System.out.println("Error al cargar el diccionario");
			System.exit(-1);
		}
		while(scan.hasNextLine()){
			linea = scan.nextLine();
			if (linea.isEmpty()) continue;
			//...
		}
		scan.close();
	}

	public void loadDocument(String file){
		Scanner scan = null;
		String linea;
		this.document.clear();
		try{
			scan = new Scanner(new File(file));
		}catch(Exception e){
			System.out.println("Error al cargar el diccionario " + e.getMessage());
			System.exit(-1);
		}

		while(scan.hasNextLine()){
			linea = scan.nextLine();
			if (linea.isEmpty()) continue;
			addToDocument(linea);
		}
		scan.close();
	}

	public void addToDocument(String line) {
		String[] lineSplit = line.toLowerCase().split("");

		//...
	}

	public void addToDictionary(LinkedList<String> words){
		//...
	}


	public LinkedList<String> compare() {
		LinkedList<String> misspelled = new LinkedList<String>();

		//...
		return misspelled;
	}


	public boolean contains(String word) {
		return this.dictionary.contains(word);
	}

	public int size() {
		return this.dictionary.size();
	}
}
