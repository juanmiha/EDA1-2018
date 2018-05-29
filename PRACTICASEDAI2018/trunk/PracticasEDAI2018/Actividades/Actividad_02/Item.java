package org.eda1.actividad02;

public class Item implements Comparable<Item>{
	private int codigo1;
	private int codigo2;
	private int contador;

	public Item(int codigo1, int codigo2){
		this.codigo1 = codigo1;
		this.codigo2 = codigo2;
		this.contador = 1;
	}

	public void incrementaContador(){
		this.contador++;
	}

	public int getContador(){
		return this.contador;
	}
	
	@Override
	public boolean equals(Object o){
	
	}

	@Override
	public String toString(){
		return "(" + this.codigo1 + "," + this.codigo2 +  ")";
	}

	@Override
	public int compareTo(Item o) {
	
	}
}
