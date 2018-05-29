package org.eda1.practica02.ejercicio03;

public class PalabraDistancia implements Comparable<PalabraDistancia> {
	private String palabra;
	private int distancia;


	public PalabraDistancia(String pal, int dis) {
		this.palabra = pal;
		this.distancia = dis;
	}

	public PalabraDistancia(String pal) {
		this.palabra = pal;
		this.distancia = Integer.MAX_VALUE;
	}

	public int getDistancia(){
		return this.distancia;
	}

	public String getPalabra(){
		return this.palabra;
	}

	@Override
	public String toString() {
		return "[" + this.palabra + " - " + this.distancia +"]";
	}

	@Override
	public int compareTo(PalabraDistancia otra) {
		if(otra.getDistancia()==distancia){
			return  palabra.compareTo(otra.getPalabra());
		}
		return (distancia > otra.getDistancia())? 1: -1;
	}

}
