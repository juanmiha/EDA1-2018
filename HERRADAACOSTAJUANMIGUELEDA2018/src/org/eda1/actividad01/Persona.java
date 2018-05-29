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
			//Orden natural -> orden de menor a mayor segun el atributo nombre; en caso de que los nombres sean iguales,
			//se ordenaría de menor a mayor segun el atributo codigo
			int compareN = this.nombre.compareTo(o.getNombre());
			return(compareN == 0)?  this.cod.compareTo(o.cod):compareN;

		}

		@Override
		public boolean equals(Object o){
				if (this == o)
					return true;
				if (o == null)
					return false;
				if (getClass() != o.getClass())
					return false;
				Persona otro = (Persona) o;
				if (cod == null) {
					if (otro.cod != null)
						return false;
				} else if (!cod.equals(otro.cod))
					return false;
				if (nombre == null) {
					if (otro.nombre != null)
						return false;
				} else if (!nombre.equals(otro.nombre))
					return false;
				return true;
			}
		public String getNombre(){
			return this.nombre;
		}

		public String getCod(){
			return this.cod;
		}
}
