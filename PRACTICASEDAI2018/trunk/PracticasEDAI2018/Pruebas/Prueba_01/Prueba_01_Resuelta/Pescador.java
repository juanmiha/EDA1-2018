package org.eda1.prueba01;

public class Pescador implements Comparable<Pescador>{
	private String nombre;
	private String apellido;
	private int id;
	private int kilos;


	public Pescador(int id){
		this.id = id;
	}

	public Pescador(int id, String nombre, String apellidos){
		this.id = id;
		this.nombre = nombre.toLowerCase();
		this.apellido = apellidos.toLowerCase();
		this.kilos = 0;

	}

	public void actualizaKilos(int...ventas){
		//Internamente, el tipo int... equivale a int[]
		for (int i=0; i<ventas.length; i++){
			kilos += ventas[i];
		}
	}

	public Integer getId(){
		return id;
	}

	public String getNombre(){
		return this.nombre;
	}

	public String getApellido(){
		return this.apellido;
	}

	public int getKilos(){
		return kilos;
	}

	@Override
	public String toString(){
		// id.- nombre apellido (kilos k) .... Si k<=0 no se muestra el valor
		return this.id + ".- " + this.nombre + " " + this.apellido + (kilos != 0 ? " (" + this.kilos + "k)" : "");
	}

	@Override
	public int compareTo(Pescador o) {
		return new Integer(this.id).compareTo(o.id);
	}
}