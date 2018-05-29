package org.eda1.prueba01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import org.eda1.edaAuxiliar.AVLTree;

public class Lonja implements Comparable<Lonja>, Iterable<Pescador>{
	private String nombre;
	private int id; 
	private AVLTree<Pescador> pescadores;
	public static int idStatic; //Imprescindible inicializar correctamente esta variable...

	public Lonja(int id){
		this.id = id;
	}
	
	public Lonja(String nombre){
		this.nombre = nombre;
		this.id = ++idStatic;
		pescadores = new AVLTree<Pescador>();
	}

	public boolean add(String nombre, String apellidos){
		return pescadores.add(new Pescador(pescadores.size() + 1, nombre, apellidos));
	}
	
	public boolean remove(int id){
		return pescadores.remove(new Pescador(id));
	}
	
	public int size(){
		return this.pescadores.size();
	}
	
	public void clear(){
		this.pescadores.clear();
	}
	
	public double getKilos(int idPescador){
		Pescador pescador = this.pescadores.find(new Pescador(idPescador));
		return (pescador == null) ? -1 : pescador.getKilos();
	}
	
	public boolean actualizaKilos(int id, int...kilos){
		Pescador p = pescadores.find(new Pescador(id));
		if (p == null) return false;
		p.actualizaKilos(kilos);
		return true; 
	}
	
	public String toStringWithOrder(Comparator<Pescador> comp){
		ArrayList<Pescador> arr = new ArrayList<Pescador>();
		for (Pescador pescador : pescadores){
			arr.add(pescador);
		}
		arr.sort(comp);
		return id + ".- " + this.nombre + " => " +  arr.toString();
	}
	
	@Override
	public String toString(){
		return id + ".- " + this.nombre + " => " + pescadores.toString();
	}

	@Override
	public int compareTo(Lonja o) {
		return new Integer(this.id).compareTo(o.id);
	}
	
	@Override
	public Iterator<Pescador> iterator() {
		return pescadores.iterator();
	}
}
