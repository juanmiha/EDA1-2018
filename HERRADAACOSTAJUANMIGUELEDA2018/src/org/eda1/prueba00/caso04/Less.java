package org.eda1.prueba00.caso04;

import java.util.Comparator;

public class Less implements Comparator<Personaje> {

	private String campo;

	public Less(String campo){
		this.campo = campo.toLowerCase();
	}

	private int compareSex(Personaje o1, Personaje o2){
		return o1.getSexo().compareTo(o2.getSexo());
	}

	private int compareProfesion(Personaje o1, Personaje o2){
		return o1.getProfesionPpal().compareTo(o2.getProfesionPpal());
	}

	private int compareEdad(Personaje o1, Personaje o2){

		return  Integer.compare(o1.getEdad(),o2.getEdad());

	}


	@Override
	public int compare(Personaje o1, Personaje o2) {
		int compSex = compareSex(o1, o2);
		int compProf = compareProfesion(o1, o2);
		int compEdad = compareEdad(o1, o2);
		int compareNatural =  o1.compareTo(o2);
		switch(this.campo){
			case "edad":
				return (compEdad==0)? compareNatural: compEdad;
			case "profesion":
				return (compProf == 0)? compareNatural: compProf;
			case "sexo":
				return (compSex == 0)? compareNatural: compSex;
			default:
				return compareNatural;
		}
	}
}
