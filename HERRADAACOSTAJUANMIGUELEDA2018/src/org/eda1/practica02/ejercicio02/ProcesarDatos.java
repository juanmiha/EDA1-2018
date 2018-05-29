package org.eda1.practica02.ejercicio02;

import java.util.ArrayList;
import java.util.Scanner;

import org.eda1.edaAuxiliar.AVLTree;

import java.io.File;
import java.io.IOException;

public class ProcesarDatos {

	private AVLTree<EmpresaProyectos> listaEmpresas = new AVLTree<EmpresaProyectos>();

	public void cargarArchivo(String archivo) {
		Scanner scan = null;
		String linea;
		String[] items;

		try {
			listaEmpresas.clear();
			scan = new Scanner(new File(archivo));
			while (scan.hasNextLine()) {
				linea = scan.nextLine();
				if (linea.isEmpty()) continue;
				if (linea.startsWith("@") || linea.startsWith(" ")) continue;
				items = linea.split(" -> ");
				add(items[0],items[1],items[2]);
			}
			scan.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}

	public boolean add(String empresa, String proyecto, String ciudad) {

		EmpresaProyectos emPro = new EmpresaProyectos(empresa);
		EmpresaProyectos curr = this.listaEmpresas.find(emPro);
		if(curr == null){
			emPro.add(proyecto, ciudad);
			this.listaEmpresas.add(emPro);
		}else{
			curr.add(proyecto, ciudad);
		}

		return curr == null;
	}

	public int size() {
		return this.listaEmpresas.size();
	}

	public int numeroProyectosEmpresa(String empresa) {
		EmpresaProyectos curr = listaEmpresas.find(new EmpresaProyectos(empresa));
		if(curr == null) return -1;
		return curr.size();
	}

	public int numeroCiudadesProyecto(String proyecto) {
		int cont = -1;
		ProyectoCiudades pc;
		for(EmpresaProyectos emPro: listaEmpresas){
			pc = emPro.find(proyecto);
			if(pc != null){
				cont = pc.size();
				break;
			}
		}
		return cont;
	}

	public int numeroCiudadesEmpresa(String empresa) {
		AVLTree<String> ciudades = new AVLTree<String>();
		EmpresaProyectos curr = listaEmpresas.find(new EmpresaProyectos(empresa));
		if(curr == null) return -1;
		for(ProyectoCiudades proCiu: curr){
			for(String aux: proCiu){
				ciudades.add(aux);
			}
		}
		return ciudades.size();
	}

	@Override
	public String toString() {
		String cadena = "";
		for (EmpresaProyectos ep : this.listaEmpresas) {
			cadena += ep.toString() + "\n";
		}
		return cadena;
	}

	public String devolverEmpresasCiudad(String ciudad) {
		ArrayList<String> empresas = new ArrayList<String>();
		for(EmpresaProyectos emPro: listaEmpresas){
			for(ProyectoCiudades proCiu: emPro){
				if(proCiu.contains(ciudad))
					if(!empresas.contains(emPro.getEmpresa()))
						empresas.add(emPro.getEmpresa());
			}
		}
		return empresas.toString();
	}

	public String devolverProyectosCiudad(String ciudad) {
		ArrayList<String> proyectos = new ArrayList<String>();
		for(EmpresaProyectos emPro: listaEmpresas){
			for(ProyectoCiudades proCiu: emPro){
				if(proCiu.contains(ciudad))
					if(!proyectos.contains(proCiu.getProyecto()))
						proyectos.add(proCiu.getProyecto());
			}
		}
		return proyectos.toString();
	}

	 public String devolverCiudadesEmpresa(String empresa) {
		 ArrayList<String> ciudades = new ArrayList<String>();
		 EmpresaProyectos curr = listaEmpresas.find(new EmpresaProyectos(empresa));
		 if(curr != null)
			 for(ProyectoCiudades proCiu: curr){
				 for(String aux: proCiu){
					 if(!ciudades.contains(aux))
						 ciudades.add(aux);
				 }
			 }

		 return ciudades.toString();
		 }
}