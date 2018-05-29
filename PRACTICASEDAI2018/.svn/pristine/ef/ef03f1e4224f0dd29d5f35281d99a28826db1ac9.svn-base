package org.eda1.actividad01;

public class Persona implements Comparable<Persona>{

		private String nombre;
		private String cod;

		public Persona(String nombre, String cod){
			this.nombre = nombre;
			this.cod = cod;
		}

		@Override
		public String toString(){
			return this.nombre + " [" + this.cod + "]";
		}

		@Override
		public int compareTo(Persona o) {
			//Orden natural -> orden de menor a mayor segun el atributo nombre; en caso de que los nombres sean iguales, se ordenaría de menor a mayor segun el atributo codigo
		}

		@Override
		public boolean equals(Object o){
			//Dos objetos son iguales si tienen, exactamente, el mismo nombre y codigo
		}

		public String getNombre(){
			return this.nombre;
		}

		public String getCod(){
			return this.cod;
		}
}
