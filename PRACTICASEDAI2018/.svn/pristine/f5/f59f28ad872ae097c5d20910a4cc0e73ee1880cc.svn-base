package org.eda1.prueba00.caso04;

import java.util.Comparator;

public class Greater implements Comparator<Personaje> {

	private String campo;
	
	public Greater(String campo){
		this.campo = campo;
	}
	@Override
	public int compare(Personaje o1, Personaje o2) {
		return -new Less(campo).compare(o1, o2);
	}

}
