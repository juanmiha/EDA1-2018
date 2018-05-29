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
			lonja = new Lonja(nombre);
			for(int i = 0;i<items.length;){
				lonja.add(items[i], items[i+1]);
				i+=2;
			}
			lonjas.add(lonja);
		}

		void loadVentas(AVLTree<Lonja> lonjas, Scanner scan, String linea){
			String[] items;
			int[] datos;
			Lonja lonja = null;
			items = linea.split("[ ;=>-]+");

			datos = new int[items.length-2];

			lonja = lonjas.find(new Lonja(Integer.parseInt(items[0])));

			if(lonja!= null){

				for(int i = 2; i < items.length;i++){

					datos[i-2] = Integer.parseInt(items[i]);
				}
				lonja.actualizaKilos(Integer.parseInt(items[1]), datos);
			}//...
		}

		void loadSeccion(AVLTree<Lonja> lonjas, Scanner scan, String linea){
			switch (this){
			case LONJA:
				loadLonja(lonjas, scan, linea);
				break;
			case VENTAS:
				loadVentas(lonjas, scan, linea);
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
		lonjas.clear();
		Lonja.idStatic=0;

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
				seccion = SECCIONES.LONJA;
				continue;
			}
			if (linea.equals("@Ventas")){
				seccion = SECCIONES.VENTAS;
				continue;
			}
			seccion.loadSeccion(lonjas, scan, linea);
		}
	}

	public Lonja find(int id){
		return lonjas.find(new Lonja(id));
	}

	public double getKilos(int idLonja, int idPescador){
		Lonja lonAux= find(idLonja);
		if(lonAux == null) return -1;
		for(Pescador it1 : lonAux){
			if(it1.getId()==idPescador) return it1.getKilos();
		}
		return -1;

	}

	public int size(){
		return this.lonjas.size();
	}

	public void clear(){
		this.lonjas.clear();
	}

	public String toStringWithOrder(int idLonja, Comparator<Pescador> comp){
		ArrayList<Pescador> arr = null;
		Lonja lonjaAux = lonjas.find(new Lonja(idLonja));
		if(lonjaAux!=null){
			arr =  new ArrayList<Pescador>();
			for(Pescador pescAux: lonjaAux)
				arr.add(pescAux);
		}
		arr.sort(comp);
		return arr.toString();
	}

	@Override
	public String toString(){
		//...
		return lonjas.toString();
	}

	@Override
	public Iterator<Lonja> iterator() {
		//...
		return lonjas.iterator();
	}
}