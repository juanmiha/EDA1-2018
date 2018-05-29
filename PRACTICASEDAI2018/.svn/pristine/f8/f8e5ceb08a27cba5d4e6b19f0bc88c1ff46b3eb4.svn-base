package org.eda1.prueba01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import org.eda1.edaAuxiliar.AVLTree;

public class Lonja implements Comparable<Lonja>, Iterable<Pescador>{
	private String nombre;
	private int id; 
	private AVLTree<Pescador> pescadores;
	public static int idStatic; //Imprescindible inicializar correctamente esta variable...en el lugar que corresponda

	public Lonja(int id){
		this.id = id;
	}
	
	public Lonja(String nombre){
		//...
	}

	public boolean add(String nombre, String apellidos){
		//..
	}
	
	public boolean remove(int id){
		//...
	}
	
	public int size(){
		return this.pescadores.size();
	}
	
	public void clear(){
		this.pescadores.clear();
	}
	
	public double getKilos(int idPescador){
		//...
	}
	
	public boolean actualizaKilos(int id, int...kilos){
		//... 
	}
	
	public String toStringWithOrder(Comparator<Pescador> comp){
		ArrayList<Pescador> arr = new ArrayList<Pescador>();
		//...
		return id + ".- " + this.nombre + " => " +  arr.toString();
	}
	
	@Override
	public String toString(){
		//...
	}

	@Override
	public int compareTo(Lonja o) {
		//Orden natural: this.id
		//...
	}
	
	@Override
	public Iterator<Pescador> iterator() {
		//...
	}
}