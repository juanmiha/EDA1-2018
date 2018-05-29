package org.eda1.actividad03.ejercicio02;

import java.io.File;
import java.util.*;

public class Thesaurus {

	private TreeMap<String, TreeSet<String>> thesaurus;

	public Thesaurus() {
		this.thesaurus = new TreeMap<String, TreeSet<String>>();
	}

	public void loadThesaurus(String file) {
		Scanner scan = null;
		String line;
		this.thesaurus.clear();
		try {
			scan = new Scanner(new File(file));
		} catch (Exception e) {
			System.out.println("Error al cargar el archivo: " + e.getMessage());
			System.exit(-1);
		}

		while (scan.hasNextLine()) {
			line = scan.nextLine();
			if (line.isEmpty()) continue;
			if (line.contains("@")) continue;
			//...
		}
		scan.close();

	}

	public void add(String... words) {
		TreeSet<String> it;
		//...
	}

	public String remove(String word) {
		//...
	}

	public boolean remove(String word, String synonym) {
		//...
	}

	public void update(String word, String... synonyms) {
		TreeSet<String> it;
		//...
	}

	public String getSynonymous(String word) {
		//...
	}

	public int size() {
		return thesaurus.size();
	}

	public int size(String word) {
		//...
	}

	public boolean isSynonymousOf(String word, String synonym) {
		//...
	}

	public boolean isSynonymous(String synonym) {
		//...
	}

	public boolean hasSynonymous(String word) {
		//...
	}

	public String toString() {
		return this.thesaurus.toString();
	}
}