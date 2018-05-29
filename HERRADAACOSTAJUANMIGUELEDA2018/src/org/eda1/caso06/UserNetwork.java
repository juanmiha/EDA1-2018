package org.eda1.caso06;

import java.io.File;
import java.util.Scanner;

import org.eda1.edaAuxiliar.AVLTree;


public class UserNetwork extends Network<User> {
	public UserNetwork() {
		super();
		this.setDirected(true);
	}

	private enum Secciones {
		USUARIO,
		DISPOSITIVO;

		void insertar(AVLTree<User> tree, String line) {
			String[] args = line.trim().split(";");
			User e = null;
			switch (this) {
			case USUARIO:
				e = new User(args[0]);
				tree.add(e);
				break;
			case DISPOSITIVO:
				e =new User(args[0]);
				tree.find(e).add(new Device(args[1],args[2]));
			break;
			}

		}
	}

	public void loadFile(String filename) {
		Scanner scan = null;
		Secciones seccion = null;
		String linea = null;
		AVLTree<User> treeUsuario = new AVLTree<User>();

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

			if (linea.contains("@Usuarios")) {
				seccion = Secciones.USUARIO;
				continue;
			}
			if (linea.contains("@Dispositivo")) {
				seccion = Secciones.DISPOSITIVO;
				continue;
			}

			seccion.insertar(treeUsuario, linea);
		}
		buildNetwork(treeUsuario);
		treeUsuario.clear();
		scan.close();
	}

	public void buildNetwork(AVLTree<User> treeUsuario) {
		for(User it: treeUsuario){
			for(User it2 : treeUsuario){
				this.addVertex(it2);
				if(!it.equals(it2) && it.interseccion(it2) != 0){
					this.addEdge(it, it2, it.interseccion(it2));
				}
			}
		}

	}
}
