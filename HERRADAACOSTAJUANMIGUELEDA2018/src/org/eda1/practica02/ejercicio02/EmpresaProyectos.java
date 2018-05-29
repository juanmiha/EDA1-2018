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
		this.empresa = empresa;
		this.proyectosCiudades = new AVLTree<ProyectoCiudades>();
	}

	/**
	 * Metodo add de proyectoCiudades
	 */
	public boolean add(String proyecto, String ciudad) {
		ProyectoCiudades  proCiu =new ProyectoCiudades(proyecto);
		ProyectoCiudades curr = proyectosCiudades.find(proCiu);
		if(curr == null){
			proCiu.add(ciudad);
			this.proyectosCiudades.add(proCiu);
		}else{
			curr.add(ciudad);
		}
		return curr == null;
	}

	public String getEmpresa(){
		return this.empresa;
	}

	public int size() {
		return proyectosCiudades.size();
	}

	public ProyectoCiudades find(String proyecto){
		return proyectosCiudades.find(new ProyectoCiudades(proyecto));
	}

	@Override
	public String toString(){
		String salida = "";
		for (ProyectoCiudades pc: proyectosCiudades){
			if(!salida.isEmpty()){
				salida += ", ";
			}
			salida += pc.toString();
		}
		return this.empresa + ": " + salida;
	}

	@Override
	public int compareTo(EmpresaProyectos otra) {
		return empresa.compareTo(otra.getEmpresa());
	}

	@Override
	public Iterator<ProyectoCiudades> iterator() {
		return proyectosCiudades.iterator();
	}
}
