package org.eda1.practica02.ejercicio01;

import java.util.Iterator;

import org.eda1.edaAuxiliar.BSTree;

public class DireccionMaquinas implements Comparable<DireccionMaquinas>, Iterable<MaquinaContador> {
	private String direccion;
	private BSTree<MaquinaContador> maquinas = new BSTree<MaquinaContador>();

	public DireccionMaquinas(String direccion) {
		this.direccion = direccion;
	}

	public boolean add(String maquina){
		MaquinaContador maq =new MaquinaContador(maquina);
		MaquinaContador curr = maquinas.find(maq);
		if(curr != null){
			curr.incrementarContador();
		}
		maquinas.add(maq);
		return curr == null;
	}

	public int getSumaContadores(){
		int cont = 0;
		for(MaquinaContador maquinaCont: maquinas){
			cont += maquinaCont.getContador();
		}
		return cont;
	}

	public MaquinaContador find(String maquina){
		return maquinas.find(new MaquinaContador(maquina));
	}

	public String getDireccion(){
		return this.direccion;
	}

	@Override
	public String toString() {
		return "{" + direccion + ", " + maquinas +  "}\n";
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