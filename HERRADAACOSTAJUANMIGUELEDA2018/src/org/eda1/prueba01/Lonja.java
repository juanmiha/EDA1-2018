package org.eda1.prueba01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import org.eda1.edaAuxiliar.AVLTree;

public class Lonja implements Comparable<Lonja>, Iterable<Pescador>{
	private String nombre;
	private int id;
	private AVLTree<Pescador> pescadores;
	public static int idStatic = 0; //Imprescindible inicializar correctamente esta variable...en el lugar que corresponda

	public Lonja(int id){
		this.id = id;
	}

	public Lonja(String nombre){
		this.nombre = nombre;
		this.id = ++idStatic;
		this.pescadores =  new AVLTree<Pescador>();
	}

	public boolean add(String nombre, String apellidos){
		return pescadores.add(new  Pescador(pescadores.size()+1, nombre, apellidos));
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
		double kilos = -1;
		Pescador pescAux = pescadores.find(new Pescador(idPescador));
		if(pescAux != null){
			kilos = pescAux.getKilos();
		}
		return kilos;
	}

	public boolean actualizaKilos(int id, int...kilos){
		Pescador pescAux = pescadores.find(new Pescador(id));
		if(pescAux == null){
			return false;
		}
		pescAux.actualizaKilos(kilos);
		return true;
	}

	public String toStringWithOrder(Comparator<Pescador> comp){
		ArrayList<Pescador> arr = new ArrayList<Pescador>();
		for(Pescador it1: pescadores){
			arr.add(it1);
		}
		arr.sort(comp);
		return id + ".- " + this.nombre + " => " +  arr.toString();
	}

	@Override
	public String toString(){
		//...
		return this.id + ".- " + this.nombre + " => " + pescadores.toString();
	}

	@Override
	public int compareTo(Lonja o) {
		//Orden natural: this.id
		//...
		return Integer.compare(this.id, o.id);
	}

	@Override
	public Iterator<Pescador> iterator() {
		//...
		return pescadores.iterator();
	}
}