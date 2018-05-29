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
		//...
	}

	public void actualizaKilos(int...ventas){
		//Internamente, el tipo int... equivale a int[]
		//...
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
		//...
	}

	@Override
	public int compareTo(Pescador o) {
		//Orden natural: this.id
		//...
	}
}