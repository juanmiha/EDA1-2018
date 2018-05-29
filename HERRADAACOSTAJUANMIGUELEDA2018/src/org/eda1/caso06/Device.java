package org.eda1.caso06;

import java.util.BitSet;

public class Device implements Comparable<Device>{

	private String nombre;
	private BitSet mascara;

	public Device() {
		super();
		nombre = "null";
		mascara = null;
	}

	public Device(String nombre, String mascara){
		super();
		this.nombre=nombre;
		this.mascara=new BitSet();
		for(int i = 0; i< mascara.length();i++ ){
			if(mascara.charAt(i)=='1'){
				this.mascara.set(i);

			}
		}

	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BitSet getMascara() {
		return mascara;
	}
	public void setMascara(BitSet mascara) {
		this.mascara = mascara;
	}
	public String toString(){
		String aux;
		aux = this.nombre + " (";
		for(int i=0;i<5;i++){
			if(mascara.get(i)==true)
				aux += "1";
			else
				aux+= "0";
		}
		aux += ")";
		return aux;
	}
	public boolean equals(Object o){
		Device tmp = (Device) o;
		String aux = "", aux2 = "";
		aux = this.nombre;
		aux2 =tmp.getNombre();
		if(aux.equals(aux2)){
			for(int i=0;i<5;i++){
				if(this.mascara.get(i)==true)
					aux += "1";
				else
					aux+= "0";
			}
			for(int i=0;i<5;i++){
				if(tmp.getMascara().get(i)==true)
					aux2 += "1";
				else
					aux2 += "0";
			}
		}
		return aux.equals(aux2);
	}

	public int interseccion(Device d2) {
		int i = 0;
		if(getMascara().intersects(d2.getMascara())){
			BitSet tmp = (BitSet) getMascara().clone();
			tmp.and(d2.getMascara());
			i += tmp.cardinality();
		}
		return i;
	}

	@Override
	public int compareTo(Device o) {
		Device tmp = (Device) o;
		String aux = "", aux2 = "";
		for(int i=0;i<5;i++){
			if(this.mascara.get(i)==true)
				aux += "1";
			else
				aux+= "0";
		}
		for(int i=0;i<5;i++){
			if(tmp.getMascara().get(i)==true)
				aux2 += "1";
			else
				aux2 += "0";
		}
		return aux.compareTo(aux2);
	}
}
