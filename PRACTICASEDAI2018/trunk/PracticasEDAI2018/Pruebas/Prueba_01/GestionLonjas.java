package org.eda1.prueba01;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

import org.eda1.edaAuxiliar.AVLTree;

public class GestionLonjas implements Iterable<Lonja> {

	private AVLTree<Lonja> lonjas;

	private enum SECCIONES {
		LONJA,
		VENTAS;
		
		void loadLonja(AVLTree<Lonja> lonjas, Scanner scan, String nombre){
			String[] items;
			Lonja lonja = null;
			items = scan.nextLine().split("[ ;]+");
			//...
		}
		
		void loadVentas(AVLTree<Lonja> lonjas, Scanner scan, String linea){
			String[] items;
			int[] datos;
			Lonja lonja = null;
			items = linea.split("[ ;=>-]+");

			//...
		}
		
		void loadSeccion(AVLTree<Lonja> lonjas, Scanner scan, String linea){
			switch (this){
			case LONJA:
				//...
				break;
			case VENTAS:
				//...
				break;
			}
		}
	}
	
	public GestionLonjas(){
		this.lonjas = new AVLTree<Lonja>();
	}

	public void load(String file){
		Scanner scan = null;
		String linea = "";
		SECCIONES seccion = null;

		//...
		
		try{
			scan = new Scanner(new File(file));
		}catch(Exception e){
			System.out.println("Error al cargar el archivo --> " + e.getMessage());
			System.exit(-1);
		}

		while(scan.hasNextLine()){
			linea = scan.nextLine();
			if (linea.isEmpty()) continue;
			if (linea.contains("%")) continue;
			if (linea.equals("@Lonjas")){
				//...
			}
			if (linea.equals("@Ventas")){
				//...
			}
			seccion.loadSeccion(lonjas, scan, linea);
		}
	}
	
	public Lonja find(int id){
		//...
	}

	public double getKilos(int idLonja, int idPescador){
		//...
	}
	
	public int size(){
		return this.lonjas.size();
	}
	
	public void clear(){
		this.lonjas.clear();
	}
	
	public String toStringWithOrder(int idLonja, Comparator<Pescador> comp){
		ArrayList<Pescador> arr = null;
		//...
		return arr.toString();
	}

	@Override
	public String toString(){
		//...
	}

	@Override
	public Iterator<Lonja> iterator() {
		//...
	}
}