package org.eda1.prueba00.caso02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import org.eda1.edaAuxiliar.AVLTree;

public class GestionTrabajador {
	private AVLTree<Trabajador> arbolPalabra = new AVLTree<Trabajador>();

	public void cargarArchivo(String nombreArchivo){
		Scanner archivo = null;
		String linea = "";
		String nombre = "";
		String[] palabrasLinea = null;
		ArrayList<Double> horasTrabajadas = null;
		this.arbolPalabra.clear();

		try{
			archivo = new Scanner(new File(nombreArchivo));

			while (archivo.hasNextLine()){

				linea=archivo.nextLine();
				if(linea.isEmpty())continue;
				if(linea.startsWith("@"))continue;
				palabrasLinea =  linea.split(" ");

				if(palabrasLinea.length==3){
					nombre = palabrasLinea[0] + " " +  palabrasLinea[1] + " " + palabrasLinea[2];
					continue;
				}
				horasTrabajadas = new ArrayList<Double>();
				for(String valor : palabrasLinea){
					if(valor.equals("-")){
						horasTrabajadas.add(null);
						continue;
					}
					horasTrabajadas.add(Double.parseDouble(valor));
				}
				arbolPalabra.add(new Trabajador(nombre,horasTrabajadas));
			}
			archivo.close();
		}catch (FileNotFoundException expt){
			System.out.println("ERROR AL CARGAR EL ARCHIVO");
			System.exit(-1);
		}
	}

	public int size(){
		return this.arbolPalabra.size();
	}

	public boolean add(Trabajador trab){
		return this.arbolPalabra.add(trab);
	}

	public Trabajador find(String nombre){
		return this.arbolPalabra.find(new Trabajador(nombre,null));
	}

	public ArrayList<Trabajador> toArray(){
		ArrayList<Trabajador> output = new ArrayList<Trabajador>();
		for(Trabajador itTrabajador: arbolPalabra){
			output.add(itTrabajador);
		}
		return output;
	}

	public ArrayList<Trabajador> toArrayWithOrder(Comparator<Trabajador> comp){
		ArrayList<Trabajador> output = new ArrayList<Trabajador>();
		for(Trabajador itTrabajador: arbolPalabra){
			output.add(itTrabajador);
		}
		output.sort(comp);
		return output;
	}

	@Override
	public String toString(){
		return this.arbolPalabra.toString();
	}
}
