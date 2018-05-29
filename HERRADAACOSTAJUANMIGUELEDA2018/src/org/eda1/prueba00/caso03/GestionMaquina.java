package org.eda1.prueba00.caso03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import org.eda1.edaAuxiliar.AVLTree;

public class GestionMaquina {
	private AVLTree<Maquina> arbol = new AVLTree<Maquina>();

	public void load(String nombreArchivo){
		Scanner archivo = null;
		String linea;
		String[] palabrasLinea;
		this.arbol.clear();

		try{
			archivo = new Scanner(new File(nombreArchivo));

			while (archivo.hasNextLine()){
				linea =  archivo.nextLine();
				if(linea.isEmpty())continue;
				if(linea.startsWith("@"))continue;
				palabrasLinea = linea.split(" ");
				add(palabrasLinea[0],palabrasLinea[1]);
			}
			archivo.close();
		}catch (FileNotFoundException expt){
			System.out.println("ERROR AL CARGAR EL ARCHIVO");
			System.exit(-1);
		}

	}

	public void add(String maquina, String ip){
		Maquina aux = new Maquina(maquina);
		if(arbol.find(aux)==null){
			aux.add(ip);
			arbol.add(aux);
		}else{
			arbol.find(aux).add(ip);
		}
	}

	public int size(){
		return this.arbol.size();
	}

	public ArrayList<String> maquinasConIp(String ip){
		ArrayList<String> output =  new ArrayList<String>();
		for(Maquina aux : arbol){
			if(aux.contains(ip)){
				output.add(aux.getNombre());
			}
		}
		return output;
	}

	public ArrayList<Maquina> toArrayWithOrder(Comparator<Maquina> comp){
		ArrayList<Maquina> output =  new ArrayList<Maquina>();
		for(Maquina aux : arbol){
			output.add(aux);
		}
		output.sort(comp);
		return output;
	}

	@Override
	public String toString(){
		return this.arbol.toString();
	}
}
