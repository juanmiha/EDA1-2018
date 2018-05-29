package org.eda1.practica01.ejercicio02;

import java.util.ArrayList;
import java.util.Iterator;

public class EmpresaProyectos implements Iterable<ProyectoCiudades>{
	private String empresa;
	private ArrayList<ProyectoCiudades> proyectosCiudades;

	/**
	 * Constructor de EmpresaProyectos
	 */
	public EmpresaProyectos(String empresa) {
		this.empresa = empresa;
		this.proyectosCiudades = new ArrayList<ProyectoCiudades>();
	}

	/**
	 * Metodo add
	 */
	public void addProyectoCiudad(String proyecto, String ciudad) {
		//Haced uso de los metodos indexOf(), contains()...
		int pos = this.proyectosCiudades.indexOf(new ProyectoCiudades(proyecto));
		if (pos != -1){
			this.proyectosCiudades.get(pos).addCiudad(ciudad);
			return;
		}
		else{
			ProyectoCiudades pc = new ProyectoCiudades(proyecto);
			pc.addCiudad(ciudad);
			proyectosCiudades.add(pc);
		}
	}


	/**
	 * Metodo getNumCiudades
	 * @param proyecto (nombre del proyecto)
	 * @return numero de ciudades
	 */
	public int getNumCiudades(String proyecto){
		for(ProyectoCiudades i: proyectosCiudades){
			if(i.getProyecto().equals(proyecto)){
				return i.size();
			}
		}
		return -1;
	}

	/**
	 * Metodo getEmpresa()
	 * @return nombreEmpresa
	 */
	public String getEmpresa(){
		return this.empresa;
	}

	/**
	 * Metodo getter del tamano
	 * @return tamano
	 */
	public int size() {
		return proyectosCiudades.size();
	}

	/**
	 * Metodo toString()
	 * @return String
	 */
	@Override
	public String toString(){
		String salida = "";
		for (ProyectoCiudades pc: proyectosCiudades){
			if(!salida.isEmpty()){
				salida += "; ";
			}
			salida += pc.toString();
		}
		return this.empresa + ": " + salida;

	}
	/**
	 * Metodo equals()
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o){
		EmpresaProyectos ep = (EmpresaProyectos) o;
		return this.empresa.equals(ep.empresa);
	}

	/**
	 * Metodo iterator
	 * @return Iterator<ProyectoCiudades>
	 */
	@Override
	public Iterator<ProyectoCiudades> iterator() {
		return proyectosCiudades.iterator();
	}
}
