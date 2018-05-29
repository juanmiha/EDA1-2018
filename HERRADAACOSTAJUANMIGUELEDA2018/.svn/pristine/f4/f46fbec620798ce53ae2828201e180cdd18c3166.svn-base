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
		if(ciudades.contains(ciudad)){
			return;
		}
		ciudades.add(ciudad);
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
		String salciudades = this.ciudades.toString();
		String salida = salciudades.substring(1,salciudades.length()-1);
		return proyecto + " <" + salida + ">";
	}

	/**
	 * Metodo equals()
	 * @return boolean
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProyectoCiudades other = (ProyectoCiudades) obj;
		if (proyecto == null) {
			if (other.proyecto != null)
				return false;
		} else if (!proyecto.equals(other.proyecto))
			return false;
		return true;
	}
	/**
	 * Metodo iterator()
	 * @return Iterator<String>
	 */
	@Override
	public Iterator<String> iterator() {
		return this.ciudades.iterator();
	}


}
