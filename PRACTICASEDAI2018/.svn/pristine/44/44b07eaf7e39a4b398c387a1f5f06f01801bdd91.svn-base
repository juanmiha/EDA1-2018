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
		//...
	}
	
	public void addLineas(int... linea){
		//...
	}
	
	public TreeSet<Integer> interseccion(Estacion otra){
		//...
	}
	
	@Override
	public String toString(){
		return "<E" + this.codigo + ", " + this.nombre + ">";
	}

	public String toStringWithDetails(){
		//...
			
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
