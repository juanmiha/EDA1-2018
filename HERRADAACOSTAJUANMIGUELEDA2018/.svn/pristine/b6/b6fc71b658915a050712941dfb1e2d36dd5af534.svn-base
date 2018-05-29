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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (codigo1 != other.codigo1)
			return false;
		if (codigo2 != other.codigo2)
			return false;
		return true;
	}
	@Override
	public String toString(){
		return "(" + this.codigo1 + "," + this.codigo2 +  ")";
	}

	@Override
	public int compareTo(Item o) {
		if(this.codigo1==o.codigo1){
			if(this.codigo2 == o.codigo2){
				return 0;
			}
			return (this.codigo2 > o.codigo2)?1:-1;
		}

		return (this.codigo1 > o.codigo1)?1:-1;
	}
}
