package org.eda1.prueba00.caso01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import org.eda1.edaAuxiliar.AVLTree;



public class GestionTexto {
	private AVLTree<Palabra> arbolPalabra = new AVLTree<Palabra>();

	public void cargarTexto (String nombreArchivo) throws FileNotFoundException{

		Scanner archivo = null;
		String linea = "";
		String[] palabrasLinea = null;
		Palabra palabraObj = null;
		this.arbolPalabra.clear();

		try{
			archivo = new Scanner(new File(nombreArchivo));

			while (archivo.hasNextLine()){
				linea = archivo.nextLine();
				if (linea.isEmpty()) continue;
				if (linea.startsWith("@")) continue;
				palabrasLinea = linea.split("[ +-.,( )[ ]¡?!¿^]+");
				for (int i=0; i<palabrasLinea.length; i++){
					if (palabrasLinea[i].contains("@")) break;
					palabraObj = new Palabra(palabrasLinea[i].toLowerCase());
					if (!arbolPalabra.contains(palabraObj)){
						arbolPalabra.add(palabraObj);
					}else {
						arbolPalabra.find(palabraObj).incrementaFrecuencia();
					}

				}
			}
			archivo.close();
		}catch (FileNotFoundException expt){
			System.out.println("ERROR AL CARGAR EL ARCHIVO");
			System.exit(-1);
		}
	}

	public int size(){
		return arbolPalabra.size();
	}

	public ArrayList<Palabra> toArray(){
		ArrayList<Palabra> resultado = new ArrayList<Palabra>();
		for(Palabra aux: arbolPalabra){
			resultado.add(aux);
		}
		return resultado;
	}


	public ArrayList<Palabra> toArrayWithOrder(Comparator<Palabra> comp){
		if (comp == null) return null;
		ArrayList<Palabra> array = this.toArray();
		Collections.sort(array,comp);//Seria mas eficiente hacer uso de una cola de prioridad??????
		return array;
	}

	@Override
	public String toString(){
		return this.toArray().toString();
	}
}