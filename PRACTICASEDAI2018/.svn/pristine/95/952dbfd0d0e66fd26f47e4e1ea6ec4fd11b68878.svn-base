package org.eda1.practica02.ejercicio01;

import java.util.Scanner;

import org.eda1.edaAuxiliar.BSTree;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class ProcesarDirecciones {

	private BSTree<DireccionMaquinas> treeDirecciones;
	 
	public ProcesarDirecciones() {
		this.treeDirecciones = new BSTree<DireccionMaquinas>();	
	}

	public void cargarArchivo(String archivo) {
		Scanner scan = null;
		String linea = "";
		String [] items = null; 
		
		this.treeDirecciones.clear();
		
		try {
			scan = new Scanner(new File(archivo));
		}catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		while (scan.hasNextLine()){
			linea = scan.nextLine();
			if (linea.isEmpty()) continue;
			//...
		}
		scan.close();
	}

	public boolean add(String direccion, String maquina) {
    	//...
	}
	
	public int size(){
		return this.treeDirecciones.size();
	}
	
	public int getSumaContadores(){
		//...
	}
	
	public int getSumaContadores(String direccion){
		//...
	}
	
	public int getContador(String direccion, String maquina){
		//...
	}
	
	public String direccionMaquinasConContador(int contador) {
		//...
	}

	public void guardarArbol(String archivo) {			
		try {
			PrintWriter out = new PrintWriter(archivo);
			out.print(treeDirecciones.toString());
			out.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}
	
	@Override
	public String toString(){
		return treeDirecciones.toString();
	}
}
