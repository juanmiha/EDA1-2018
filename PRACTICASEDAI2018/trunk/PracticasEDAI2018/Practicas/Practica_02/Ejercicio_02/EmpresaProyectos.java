package org.eda1.practica02.ejercicio02;

import java.util.Iterator;

import org.eda1.edaAuxiliar.AVLTree;

public class EmpresaProyectos implements Comparable<EmpresaProyectos>, Iterable<ProyectoCiudades> {
	
	private String empresa;
	private AVLTree<ProyectoCiudades> proyectosCiudades;
	
	/**
	 * Constructor de EmpresaProyectos
	 */
	public EmpresaProyectos(String empresa) {
		//...
	}

	/**
	 * Metodo add de proyectoCiudades
	 */
	public boolean add(String proyecto, String ciudad) {
		//...
	}

	public String getEmpresa(){
		return this.empresa;
	}
	
	public int size() {
		return proyectosCiudades.size();
	}
	
	public ProyectoCiudades find(String proyecto){
		//...
	}

	@Override
	public String toString(){
		//...
	}

	@Override
	public int compareTo(EmpresaProyectos otra) {
		//...
	}

	@Override
	public Iterator<ProyectoCiudades> iterator() {
		return proyectosCiudades.iterator();
	}
}
