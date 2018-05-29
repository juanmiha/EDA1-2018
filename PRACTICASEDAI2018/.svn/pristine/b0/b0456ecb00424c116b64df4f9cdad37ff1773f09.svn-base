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
			//...
	}
}
