package org.eda1.prueba00.caso02;

import java.util.ArrayList;
import java.util.Locale;

public class Trabajador implements Comparable<Trabajador>{
	private String nombre;
	private ArrayList<Double> horasDia;

	private String format(double num){
		return String.format(Locale.US, "%.2f", num);
	}

	public Trabajador (String nombre, ArrayList<Double> horasDia){
		this.nombre = nombre.toLowerCase();
		this.horasDia = horasDia ;
	}

	public double horasMes(){
		double contador = 0;
		if(this.horasDia!=null){
			for(Double aux: horasDia){
				if(aux != null)
					contador+=(double)aux;
			}
		}
		return contador;
	}

	public double mediaHorasMes(){
		return this.horasMes() / 30;
	}

	@Override
	public String toString(){
		return this.nombre.toUpperCase() + " <" + format(horasMes()) + ", " + format(mediaHorasMes()) + ">";
	}

	public String toStringExtend(){
		if(horasDia == null)
			return this.nombre.toUpperCase() + " --> []";
		return this.nombre.toUpperCase() + " --> " + horasDia.toString();
	}

	@Override
	public int compareTo(Trabajador otro){
		String[] trab1 = this.nombre.split(" ");
		String[] trab2 = otro.nombre.split(" ");
		int compare = trab1[1].compareTo(trab2[1]);
		if(compare == 0){
			compare = trab1[2].compareTo(trab2[2]);
			if(compare == 0)
				compare = trab1[0].compareTo(trab2[0]);
		}
		return compare;
	}
}