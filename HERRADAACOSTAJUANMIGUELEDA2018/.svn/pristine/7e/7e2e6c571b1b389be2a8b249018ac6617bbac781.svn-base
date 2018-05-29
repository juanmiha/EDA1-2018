package org.eda1.prueba00.caso01;

public class Palabra implements Comparable<Palabra>{
	private String palabra;
	private int frecuencia;

	Palabra(){
		this.palabra = "";
		this.frecuencia = -1;
	}

	Palabra(String palabra){
		this.palabra = palabra;
		this.frecuencia = 1;
	}

	Palabra(Palabra pal){
		this.palabra = pal.palabra;
		this.frecuencia = pal.getFrecuencia();
	}

	public int getFrecuencia(){
		return this.frecuencia;
	}

	public void incrementaFrecuencia(){
		this.frecuencia++;
	}

	public int getLongitud(){
		return this.palabra.length();
	}

	@Override
	public int compareTo(Palabra other) {
		return this.palabra.compareTo(other.palabra);
	}

	@Override
	public String toString(){
		if(getFrecuencia() == -1)
			return "[?]";
		return this.palabra.toLowerCase() + " <" + this.palabra.length() + "," + this.frecuencia + ">";
	}
}
