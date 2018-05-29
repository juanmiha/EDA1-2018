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
		//...
	}
	
	public double horasMes(){
		//...
	}
	
	public double mediaHorasMes(){
		return this.horasMes() / 30;
	}
	
	@Override
	public String toString(){
		//...
	}
	
	public String toStringExtend(){
		//...
	}
	
	@Override
	public int compareTo(Trabajador otro){
		//...	
	}
}