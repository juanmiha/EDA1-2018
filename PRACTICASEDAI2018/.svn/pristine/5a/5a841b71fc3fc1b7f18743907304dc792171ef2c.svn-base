package org.eda1.practica03.ejercicio01;

import java.util.ArrayList;
import java.util.Map;
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

			//...
			
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
		
		//...
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
		
		//...
		
		out.close();

	}

	public ArrayList<String> maquinasConContadorMayorQue(int contador) {
		ArrayList<String> arr = new ArrayList<String>();

		//...
		
		return arr;
	}

	public int maquinasConContadorIgualA(int contador) {
		int cont = 0;
		
		//...
		
		return cont;
	}

	public int getContador(String direccion, String maquina) {
		//...
	}

	public ArrayList<String> incidenciasGeneradasPorIP(String direccion) {
		ArrayList<String> arr = null;

		//..
		
		return arr;
	}

	public int numeroDeIncidenciasGeneradasPorIP(String direccion) {
		//...
	}
}