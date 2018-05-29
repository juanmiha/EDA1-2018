package org.eda1.prueba02;

import java.util.BitSet;

public class Device {
	
	private int id; //Identificador de dispositivo relacionado con el parametro Parameters.NUM_DEVICES
	private BitSet code; //Codigo binario de longitud Parameters.CODE_LENGTH en el que se indica la presencia/ausencia de determinadas caraceteristicas

	
	public Device(String code) throws Exception{
		//...
	}

	public int intersects(Device o){
		int num = 0;
		//El computo de la interseccion de 2 dispositivos equivale al conteo del numero de caracteristicas comunes (numero de 1 en la misma posicion)
		return num;
	}

	@Override
	public String toString(){
		String res = "";
		//...
		return res;
	}

	@Override
	public int compareTo(Device o) {
		//Orden natural --> id
	}

	@Override
	public boolean equals(Object o){
		//Debera ser coherente con el metodo compareTo()
	}

}
