package org.eda1.practica01.ejercicio02;

import java.util.ArrayList;
import java.util.Iterator;

public class ProyectoCiudades implements Iterable<String>{
	private String proyecto;
	private ArrayList<String> ciudades;
	
	/**
	 * Constructor 
	 */
	public ProyectoCiudades(String proy) {
		this.proyecto = proy;
		this.ciudades = new ArrayList<String>();
	}

	/**
	 * Metodo getter del proyecto
	 * @return proyecto
	 */
	public String getProyecto() {
		return proyecto;
	}

	/**
	 * Metodo add de las ciudades. Antes de insertar, comprobamos que la ciudad no existe (no queremos duplicados)
	 */
	public void addCiudad(String ciudad) {
		
	}

	/**
	 * Metodo getter del tamano
	 * @return tamano
	 */
	public int size() {
		return ciudades.size();
	}
	
	/**
	 * Metodo toString()
	 * @return String
	 */
	@Override
	public String toString(){

	}
	
	/**
	 * Metodo equals()
	 * @return boolean
	 */
	@Override 
	public boolean equals(Object o){
		//...
	}

	/**
	 * Metodo iterator()
	 * @return Iterator<String>
	 */
	@Override
	public Iterator<String> iterator() {
		//...
	}
}
