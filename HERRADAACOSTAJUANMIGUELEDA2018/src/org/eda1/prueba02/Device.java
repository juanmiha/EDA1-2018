package org.eda1.prueba02;

import java.util.BitSet;

public class Device implements Comparable<Device> {

	private int id; //Identificador de dispositivo relacionado con el parametro Parameters.NUM_DEVICES
	private BitSet code; //Codigo binario de longitud Parameters.CODE_LENGTH en el que se indica la presencia/ausencia de determinadas caraceteristicas


	public Device(String code) throws Exception{
		//...

		if(code.length()<Parameters.CODE_LENGTH){
			throw new RuntimeException("Code length = 10");
		}
		this.id = Parameters.NUM_DEVICES++;
		this.code = new BitSet();
		for(int i =0;i<Parameters.CODE_LENGTH;i++){
			if(code.charAt(i)=='1'){
				this.code.set(i);
			}
		}
	}

	public int intersects(Device o){
		int num = 0;
		//El computo de la interseccion de 2 dispositivos equivale al conteo del numero de caracteristicas comunes (numero de 1 en la misma posicion)
		if(this.code.intersects(o.code)){
			BitSet tmp =(BitSet)this.code.clone();
			tmp.and(o.code);
			num = tmp.cardinality();
		}
		return num;
	}

	@Override
	public String toString(){
		//Device #2 with code 1110001110"
		String res = "Device #" + this.id + " with code ";
		for(int i = 0;i<Parameters.CODE_LENGTH;i++){
			if(this.code.get(i)==true){
				res += "1";
			}else
				res += "0";
		}
		//...

		return res;
	}

	@Override
	public int compareTo(Device o) {
		//Orden natural --> id
		if(this.id>o.id)return 1;
		if(this.id<o.id)return-1;
		return 0;
	}

	@Override
	public boolean equals(Object o){
		//Debera ser coherente con el metodo compareTo()
		Device tmp = (Device) o;
		if(this.id==tmp.id){
			return true;
		}
		return false;
	}

}
