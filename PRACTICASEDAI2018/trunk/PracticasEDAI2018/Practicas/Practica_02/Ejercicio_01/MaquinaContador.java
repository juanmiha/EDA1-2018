package org.eda1.practica02.ejercicio01;

public class MaquinaContador implements Comparable<MaquinaContador> {
	private String maquina;
	private int contador;

 	public MaquinaContador(String maquina) {
		this.maquina = maquina;
		this.contador = 1;
	}

	public void incrementarContador() {
		this.contador++;
	}

	public String getMaquina(){
		return this.maquina;
	}
	
	public int getContador(){
		return this.contador;
	}

	@Override
	public String toString() {
		return "[" + maquina + ", " + contador + "]";
	}

	@Override
	public int compareTo(MaquinaContador otra) {
		//...
	}
}
