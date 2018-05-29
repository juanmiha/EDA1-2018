package org.eda1.practica02.ejercicio02;

import java.util.Iterator;

import org.eda1.edaAuxiliar.AVLTree;

public class ProyectoCiudades implements Comparable<ProyectoCiudades>, Iterable<String> {
	private String proyecto;
	private AVLTree<String> ciudades;

	/**
	 * Constructores de ProyectoCiudades
	 */

	public ProyectoCiudades(String proyecto){
		this.proyecto = proyecto;
		this.ciudades = new AVLTree<String>();
	}

	public boolean add(String ciudad) {
		return ciudades.add(ciudad);
	}

	public String getProyecto(){
		return this.proyecto;
	}

	public int size() {
		return ciudades.size();
	}

	public boolean contains(String ciudad){
		return this.ciudades.contains(ciudad);
	}

	@Override
	public String toString(){
		String salciudades = this.ciudades.toString();
		String salida = salciudades.substring(1,salciudades.length()-1);
		return proyecto + "<" + salida + ">";
	}


	@Override
	public int compareTo(ProyectoCiudades otro) {
		return proyecto.compareTo(otro.getProyecto());
	}

	@Override
	public Iterator<String> iterator() {
		return ciudades.iterator();
	}



}
