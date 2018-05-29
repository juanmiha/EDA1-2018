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
			add(line.toLowerCase().split("[ .,:{}+]+"));
		}
		scan.close();

	}

	public void add(String... words) {
		TreeSet<String> it = new TreeSet<String>();
		for(int i = 1;i<words.length;i++){
			if(!thesaurus.containsKey(words[0])){
				thesaurus.put(words[0], new TreeSet<String>());
			}
			it.add(words[i]);
			thesaurus.get(words[0]).addAll(it);
		}
	}

	public String remove(String word) {
		if(thesaurus.containsKey(word)){
			return "" + thesaurus.remove(word);

		}
		return null;
	}

	public boolean remove(String word, String synonym) {
		return (thesaurus.containsKey(word))?thesaurus.get(word).remove(synonym):false;

	}

	public void update(String word, String... synonyms) {
		TreeSet<String> it;
		if(!thesaurus.containsKey(word)){
			return;
		}
		it = new TreeSet<String>();
		for(String synonym : synonyms){
			it.add(synonym);
		}
		thesaurus.get(word).clear();
		thesaurus.get(word).addAll(it);
	}

	public String getSynonymous(String word) {
		if(thesaurus.containsKey(word) ){
			return thesaurus.get(word).toString();
		}
		return null;
	}

	public int size() {
		return thesaurus.size();
	}

	public int size(String word) {
		if(thesaurus.containsKey(word)){
			return thesaurus.get(word).size();
		}
		return 0;
	}

	public boolean isSynonymousOf(String word, String synonym) {
		if(thesaurus.containsKey(word)){
			return thesaurus.get(word).contains(synonym);
		}
		return false;
	}

	public boolean isSynonymous(String synonym) {
		for(TreeSet<String> itSynonym : thesaurus.values()){
			if(itSynonym.contains(synonym)){
				return true;
			}
		}
		return false;
	}

	public boolean hasSynonymous(String word) {
		if(thesaurus.containsKey(word) && thesaurus.get(word).size()>0){
			return true;
		}
		return false;
	}

	public String toString() {
		return this.thesaurus.toString();
	}
}