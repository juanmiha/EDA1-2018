package org.eda1.practica04;

import java.io.File;
import java.util.Scanner;

public class RoadNetwork extends Network<String> {

	private enum Secciones {
			Type, Vertex, Edge;
			void load(RoadNetwork net, String linea){
				switch (this){
				case Type:
					if(linea.equals("Not Directed"))
						net.setDirected(false);
					else
						net.setDirected(true);
					break;
				case Vertex:
					net.addVertex(linea);
					break;
				case Edge:
					String[] arista = linea.split(" ");
					net.addEdge(arista[0],arista[1],Double.parseDouble(arista[2]));
					break;
				}

			}
	}

	public void loadRoadNetwork(String filename){
		String line = "";
		Scanner scan = null;
		Secciones seccion = null;

		try{
			scan = new Scanner(new File(filename));
		}catch(Exception e){
			System.out.println("Error al cargar el archivo --> " + e.getMessage());
			System.exit(-1);
		}

		while(scan.hasNextLine()){
			line = scan.nextLine();
			if(line.isEmpty())continue;
			if(line.startsWith("%"))continue;
			//...
			if(line.trim().startsWith("@Type")){
				seccion = Secciones.Type;
				continue;
			}
			if(line.trim().startsWith("@Vertex")){
				seccion = Secciones.Vertex;
				continue;
			}
			if(line.trim().startsWith("@Edges")){
				seccion = Secciones.Edge;
				continue;
			}
			seccion.load(this, line);
		}
	}
}
