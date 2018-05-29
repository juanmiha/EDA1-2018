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
			if (linea.startsWith("@")) continue;
			items = linea.split(" ");
			this.add(items[0], items[1]);
		}
		scan.close();
	}

	public boolean add(String direccion, String maquina) {
    	DireccionMaquinas dirMaq = new DireccionMaquinas(direccion);
    	DireccionMaquinas curr = treeDirecciones.find(dirMaq);
    	if(curr == null){
    		dirMaq.add(maquina);
    		treeDirecciones.add(dirMaq);
    	}else{
    		curr.add(maquina);
    	}
    	return curr == null;
	}

	public int size(){
		return this.treeDirecciones.size();
	}

	public int getSumaContadores(){
		int contador = 0;
		for(DireccionMaquinas dirMaq: treeDirecciones){
			contador += dirMaq.getSumaContadores();
			}
		return contador;
	}

	public int getSumaContadores(String direccion){
		DireccionMaquinas curr = treeDirecciones.find(new DireccionMaquinas(direccion));
		return (curr == null)?-1: curr.getSumaContadores();
	}

	public int getContador(String direccion, String maquina){
    	DireccionMaquinas curr = treeDirecciones.find(new DireccionMaquinas(direccion));
		MaquinaContador maqCont;
    	if(curr == null) return -1;

    	maqCont = curr.find(maquina);

    	if(maqCont == null) return -1;

		return maqCont.getContador();

	}

	public String direccionMaquinasConContador(int contador) {
		String salida = "";
		for(DireccionMaquinas dirMaq: treeDirecciones){
			for(MaquinaContador maqCont: dirMaq){
				if(contador == maqCont.getContador()){
					salida += "(" + dirMaq.getDireccion() + ", " + maqCont.getMaquina() + ")\n";
				}
			}
		}
		return salida;
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
