package org.eda1.practica04;

import java.io.File;
import java.util.Scanner;

public class RoadNetwork extends Network<String> {
	
	private enum Secciones {
			Type, Vertex, Edge;
			void load(RoadNetwork net, String linea){
				switch (this){
				case Type: 
					//...
					break;
				case Vertex:
					//...
					break;
				case Edge:
					//...
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
			
			//...
			
			seccion.load(this, line);
		}
	}
}
