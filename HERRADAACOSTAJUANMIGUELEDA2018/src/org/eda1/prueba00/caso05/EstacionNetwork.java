package org.eda1.prueba00.caso05;

import java.io.File;
import java.util.Scanner;

import org.eda1.actividad02.AVLTree;

public class EstacionNetwork extends Network<Estacion> {

	public EstacionNetwork() {
		super();
		this.setDirected(true);
	}

	private enum Secciones {
		ESTACIONES,
		LINEAS,
		DATOS_ESTACIONES;

		void insertar(AVLTree<Estacion> tree, String line) {
			String[] args = line.split(" ");
			int codigo = Integer.parseInt(args[0].substring(1));
			Estacion e = null;
			switch (this) {
			case ESTACIONES:
				e =  new Estacion(codigo,args[1]);
				tree.add(e);
				break;
			case DATOS_ESTACIONES:
				e = 	tree.find(new Estacion(codigo));
				if(e!=null) e.addDatos(args[2],Double.parseDouble(args[3]));
				break;
			case LINEAS:
				for(int i = 2;i<args.length;i++){
					int codigo2 = Integer.parseInt(args[i].substring(1));
					tree.find(new Estacion(codigo2)).addLineas(codigo);
				}
				break;
			}
		}
	}
	public void loadFile(String filename) {
		Scanner scan = null;
		Secciones seccion = null;
		String linea = null;
		AVLTree<Estacion> treeEstaciones = new AVLTree<Estacion>();

		try {
			scan = new Scanner(new File(filename));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}

		while (scan.hasNextLine()) {
			linea = scan.nextLine().trim();
			if (linea.isEmpty()) continue;
			if (linea.contains("%")) continue;

			if (linea.contains("@Estaciones")) {
				seccion = Secciones.ESTACIONES;
				continue;
			}
			if (linea.contains("@Lineas")) {
				seccion = Secciones.LINEAS;
				continue;
			}
			if (linea.contains("@DatosEstaciones")) {
				seccion = Secciones.DATOS_ESTACIONES;
				continue;
			}
			seccion.insertar(treeEstaciones, linea);
		}
		buildNetwork(treeEstaciones);
		treeEstaciones.clear();
		scan.close();
	}

	public void buildNetwork(AVLTree<Estacion> estaciones) {

		for(Estacion it: estaciones){
			for(Estacion it2 : estaciones){
				this.addVertex(it2);
				if (!it.equals(it2) && it.interseccion(it2).size()!=0){
					this.addEdge(it, it2, it.interseccion(it2).size());
					this.addEdge(it2, it, it.interseccion(it2).size());
				}
			}
		}
	}
}
