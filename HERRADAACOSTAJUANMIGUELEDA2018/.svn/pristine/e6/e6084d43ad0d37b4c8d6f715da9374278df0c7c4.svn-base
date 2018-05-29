package org.eda1.practica03.ejercicio01;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ProcesarDirecciones {

	private TreeMap<String, TreeMap<String, Integer>> mapa;

	public ProcesarDirecciones() {
		this.mapa = new TreeMap<String, TreeMap<String, Integer>>();
	}

	/**
	 * Metodo que lee las lineas (IP, maquina) del archivo de entrada
	 * correspondiente y genera un TreeMap de objetos Direccion-Maquina
	 *
	 * @param ruta
	 *            del archivo de las lineas (IP, maquina)
	 * @return
	 */
	public void cargarArchivo(String archivo) {

		Integer cont = null;
		String[] items = null;
		String linea;
		Scanner scan = null;
		try {
			scan = new Scanner(new File(archivo));
		} catch (IOException e) {
			System.out.println("Error al cargar archivo");
			System.exit(-1);
		}
		while (scan.hasNextLine()) {
			linea = scan.nextLine();
			if (linea.isEmpty()) continue;

			items = linea.split("[ ,(+]+"); //Atencion al patron que se utiliza..

			if(!mapa.containsKey(items[0])){
				mapa.put(items[0],new TreeMap<String,Integer>());
			}
			cont = mapa.get(items[0]).get(items[1]);
			if(cont == null){
				mapa.get(items[0]).put(items[1],1);
			}else{
				mapa.get(items[0]).put(items[1], ++cont);
			}

		}
		scan.close();
	}
	public int size() {
		return mapa.size();
	}

	public void generarDirecciones(String archivo) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(archivo);
		} catch (IOException e) {
			System.out.println("Error al construir archivo de direcciones");
			System.exit(-1);
		}
		for(Entry<String, TreeMap<String,Integer>> itDirecciones: mapa.entrySet()){
			out.println(itDirecciones.getKey()+ " ==> " + itDirecciones.getValue().toString());
		}
		out.close();

	}

	public void generarIncidencias(String archivo) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(archivo);
		} catch (IOException e) {
			System.out.println("Error al construir archivo de incidencias");
			System.exit(-1);
		}
		for(Entry<String, TreeMap<String,Integer>> itDirecciones: mapa.entrySet()){
			for(Entry<String,Integer> itMaquinas : itDirecciones.getValue().entrySet()){
				if(itMaquinas.getValue()>1){
					out.println(itDirecciones.getKey()+ " ==> " + itDirecciones.getValue().toString());
					break;
				}
			}
		}
		out.close();

	}

	public ArrayList<String> maquinasConContadorMayorQue(int contador) {
		ArrayList<String> arr = new ArrayList<String>();
		for(Entry<String, TreeMap<String,Integer>> itDirecciones: mapa.entrySet()){
			for(Entry<String,Integer> itMaquinas : itDirecciones.getValue().entrySet()){
				if(itMaquinas.getValue().intValue()>contador){
					arr.add(itMaquinas.getKey());
				}
			}
		}

		return arr;
	}

	public int maquinasConContadorIgualA(int contador) {
		int cont = 0;
		for(Entry<String, TreeMap<String,Integer>> itDirecciones: mapa.entrySet()){
			for(Entry<String,Integer> itMaquinas : itDirecciones.getValue().entrySet()){
				if(itMaquinas.getValue().intValue() == contador){
					cont++;
				}
			}
		}

		return cont;
	}

	public int getContador(String direccion, String maquina) {
		Integer cont = null;
		if(!mapa.containsKey(direccion)){
			return 0;
		}
		cont = mapa.get(direccion).get(maquina);
		if(cont == null){
			return 0;
		}
		return cont;
	}

	public ArrayList<String> incidenciasGeneradasPorIP(String direccion) {
		ArrayList<String> arr = new ArrayList<String>();
		if(!mapa.containsKey(direccion)){
			return null;
		}
		for(Entry<String, TreeMap<String,Integer>> itDirecciones: mapa.entrySet()){
			if(direccion.equals(itDirecciones.getKey()))
			for(Entry<String,Integer> itMaquinas : itDirecciones.getValue().entrySet()){
					arr.add(itMaquinas.getKey());
			}
		}

		return arr;
	}

	public int numeroDeIncidenciasGeneradasPorIP(String direccion) {
		int contador = 0;
		if(!mapa.containsKey(direccion)){
			return 0;
		}
		for(Entry<String, TreeMap<String,Integer>> itDirecciones: mapa.entrySet()){
			if(direccion.equals(itDirecciones.getKey())){
				for(Entry<String,Integer> itMaquinas : itDirecciones.getValue().entrySet()){
					 contador = itMaquinas.getValue();
				}
			}
		}
		return contador;
	}
}