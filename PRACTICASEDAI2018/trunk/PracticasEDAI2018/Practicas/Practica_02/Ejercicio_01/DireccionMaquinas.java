package org.eda1.practica02.ejercicio01;

import java.util.Iterator;

import org.eda1.edaAuxiliar.BSTree;

public class DireccionMaquinas implements Comparable<DireccionMaquinas>, Iterable<MaquinaContador> {
	private String direccion;
	private BSTree<MaquinaContador> maquinas = new BSTree<MaquinaContador>();
	
	public DireccionMaquinas(String direccion) {
		this.direccion = direccion;
	}

	public boolean add(String maquina) {
		//...
		return curr == null;
	}

	public int getSumaContadores(){
		int cont = 0;
		//...
		return cont;
	}
	
	public MaquinaContador find(String maquina){
		//...
	}
	
	public String getDireccion(){
		return this.direccion;
	}
	
	@Override
	public String toString() {
		//...
	}

	@Override
	public int compareTo(DireccionMaquinas otra) {
		return this.direccion.compareTo(otra.direccion);
	}
	
	@Override
	public Iterator<MaquinaContador> iterator() {
		return maquinas.iterator();
	}
}