package org.eda1.prueba00.caso04;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import org.eda1.edaAuxiliar.AVLTree;

public class GestionPersonajes {

	private AVLTree<Personaje> treePersonaje;
	
	public GestionPersonajes(){
		this.treePersonaje = new AVLTree<Personaje>();
	}
	
	public void loadFile(String file){
		Scanner scan = null;
		String linea = "";
		String[] items = null;
		boolean personajes = false;
		this.treePersonaje.clear();
		try{
			scan = new Scanner(new File(file));
		}catch(Exception e){
			System.out.println("Error al cargar el archivo --> " + e.getMessage());
			System.exit(-1);
		}
		
		while(scan.hasNextLine()){
			//...
		}
		scan.close();
	}
	
	public boolean add(Personaje p){
		return this.treePersonaje.add(p);
	}
	
	public boolean addValues(String nick, String...items){
		Personaje p = this.treePersonaje.find(new Personaje(nick));
		if (p == null) return false;
		for (String item : items){
			switch (item) {
			case "p":
				p.incrementaNumPeliculas();
				break;
			case "l":
				p.incrementaNumLibros();
				break;
			case "d":
				p.incrementaNumDiscos();
				break;
			}	
		}
		return true;
		
	}

	public void clear(){
		this.treePersonaje.clear();
	}
	
	public Personaje find(String nick){
		return this.treePersonaje.find(new Personaje(nick));
	}

	public int size(){
		return this.treePersonaje.size();
	}
	
	@Override
	public String toString(){
		return this.toString(null);
	}
	
	public String toString(Comparator<Personaje> comp){
		ArrayList<Personaje> aux = new ArrayList<Personaje>();
		for (Personaje p : treePersonaje)
			aux.add(p);
		aux.sort(comp);
		return aux.toString();
	}
}
