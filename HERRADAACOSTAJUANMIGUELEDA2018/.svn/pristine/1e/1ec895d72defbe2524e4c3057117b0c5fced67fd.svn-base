package org.eda1.actividad01;

import java.util.Comparator;

public class ComparatorPersona implements Comparator<Persona> {

	private enum Atributo {NOMBRE, COD};
	private Atributo atName;
	private boolean ordenAsc;

	public ComparatorPersona(String atributo, boolean ordenAsc){
		this.ordenAsc = ordenAsc;
		switch(atributo.toLowerCase()){
		case "nombre":
			this.atName = Atributo.NOMBRE;
			break;
		case "cod":
			this.atName = Atributo.COD;
			break;
		default :
			this.atName = Atributo.NOMBRE;
			break;
		}
	}

	@Override
	public int compare(Persona o1, Persona o2) {
		int result = 0;
		switch(atName){
		case NOMBRE:
			result = compare(o1, o2, o1.getNombre(), o2.getNombre());
			break;
		case COD:
			result = compare(o1, o2, o1.getCod(), o2.getCod());
			break;
		}
		return result;
	}

	private int compare(Persona o1, Persona o2, String cad1, String cad2){
		/*int compareInv = cad2.compareTo(cad1);
		int compare = cad1.compareTo(cad2);
		int compareNombre = o1.getNombre().compareTo(o2.getNombre());
		if (!ordenAsc)
			return (compareInv == 0) ? compareNombre:compareInv;

		return (compare == 0) ? compareNombre:compare;
		 */
		int resultado = cad1.compareTo(cad2);

		if(resultado == 0){
			return o1.compareTo(o2);
		}

		return ordenAsc ? resultado : -resultado;

	}

}
