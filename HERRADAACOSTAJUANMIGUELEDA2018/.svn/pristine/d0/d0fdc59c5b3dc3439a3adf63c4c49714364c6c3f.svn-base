package org.eda1.prueba00.caso05;

import java.util.TreeSet;

public class Estacion implements Comparable<Estacion>{
	private Integer codigo;
	private String nombre;
	private String ubicacion;
	private double m2;
	TreeSet<Integer> lineas;

	public Estacion(Integer codigo){
		this.codigo = codigo;
		this.nombre = null;
		this.ubicacion = null;
		this.m2 = .0;
	}

	public Estacion(Integer codigo, String nombre){
		this.codigo = codigo;
		this.nombre = nombre;
		this.ubicacion = null;
		this.m2 = .0;
	}

	public void addDatos(String calle, double m2){
		this.ubicacion = calle;
		this.m2 = m2;
	}

	public void addLineas(int... linea){
		if(lineas == null){
			this.lineas = new TreeSet<Integer>();
		}
		for(int it: linea){
			lineas.add(it);
		}
	}

	public TreeSet<Integer> interseccion(Estacion otra){
		TreeSet<Integer> salida;
		salida = new TreeSet<Integer>();
		for(Integer it : this.lineas){
			if(otra.lineas.contains(it)){
				salida.add(it);
			}
		}
		return salida;
	}

	@Override
	public String toString(){
		return "<E" + this.codigo + ", " + this.nombre + ">";
	}

	public String toStringWithDetails(){
		if(lineas== null){
			return "<E" + this.codigo + ", " + this.nombre + "> [" + this.ubicacion + ", " + this.m2 + "] --> null";
		}

		return "<E" + this.codigo + ", " + this.nombre + "> [" + this.ubicacion + ", " + this.m2 + "] --> " + lineas.toString();

	}

	@Override
	public int compareTo(Estacion o) {
		return this.codigo.compareTo(o.codigo);
	}

	@Override
	public boolean equals(Object o){
		return ((Estacion)o).codigo.equals(this.codigo);
	}
}
