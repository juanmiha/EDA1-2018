package org.eda1.prueba01;

import java.util.Comparator;

public class Less implements Comparator<Pescador> {

	private enum ATRIBUTO {NOMBRE,APELLIDO};	
	private ATRIBUTO campo;

	public Less(String campo) throws Exception{
		switch (campo.toLowerCase()){
		case "nombre": 
			this.campo = ATRIBUTO.NOMBRE; 
			break;
		case "apellido" : 
			this.campo = ATRIBUTO.APELLIDO; 
			break;
		default: throw new RuntimeException("Este atributo no existe");
		}
	}
	
	@Override
	public int compare(Pescador o1, Pescador o2) {
		int comp = 0;
		switch(campo){
		case NOMBRE:
			//...
			// Ordenamos primero por nombre y luego por apellido
			
			break;
		case APELLIDO:
			//...
			// Ordenamos primero por apellido y luego por nombre
			break;
		}
		//En caso de empate, orden natural
	}
}
