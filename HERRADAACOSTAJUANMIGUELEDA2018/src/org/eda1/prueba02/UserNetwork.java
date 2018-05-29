package org.eda1.prueba02;

import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class UserNetwork extends Network<User> {

	public UserNetwork() {
		super();
		this.setDirected(false); //Nuestro grafo es NO Dirigido...
	}

	private enum Sections {
		DEVICES,
		USERS;

		void add(TreeMap<String, Device> devices, TreeSet<User> users, String line) throws Exception {
			String items[] = null;
			switch(this){
			case DEVICES:
				items = line.split(" ");
				devices.put(items[1], new Device(items[4]));
				break;
			case USERS:
				items = line.split(" ");
				User temp = new User(items[0]);
				for (int i = 2; i < items.length; i++) {
					if(devices.containsKey(items[i])){
						temp.addDevice(devices.get(items[i]));
					}
				}
				users.add(temp);
				break;
			}
		}
	}

	public void loadFile(String filename) throws Exception {
		Scanner scan = null;
		Sections section = null;
		String line = null;
		TreeSet<User> users = null;
		TreeMap<String, Device> devices = null;

		//Preparacion de la estructura e inicializacion de parametros
		//...
		this.clear();
		Parameters.NUM_DEVICES = 0;
		Parameters.NUM_INTERSECTS = 0;
		Parameters.NUM_USERS = 0;

		try {
			scan = new Scanner(new File(filename));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}

		users = new TreeSet<User>();
		devices = new TreeMap<String, Device>();

		while (scan.hasNextLine()) {
			line = scan.nextLine().trim().toLowerCase();
			if (line.isEmpty()) continue;
			if (line.contains("%")) continue;

			if (line.contains("@devices")) {
				section = Sections.DEVICES;
				continue;
			}
			if (line.contains("@users")) {
				section = Sections.USERS;
				continue;
			}
			section.add(devices, users, line.toLowerCase());
		}
		buildNetwork(users);
		users.clear();
		devices.clear();
		scan.close();
	}

	public void buildNetwork(TreeSet<User> users) {
		int w = 0; //peso de la arista
		//A partir del TreeSet<T> users construimos la red calculando el grado de relacion de los usuarios mediante el uso del metodo intersects()
		//Habra que tener en cuenta que se trata de un grafo no dirigido sin bucles..
		//Por lo tanto, no se realizara el computo de ui.intersects(ui) y, ademas, tendremos en cuenta la propiedad conmutativa u1.intersects(u2) == u2.intersects(u1).
		//...
		for (User t1 : users) {
			for (User t2 : users) {
				if(t1.equals(t2)) continue;
				if(t1.compareTo(t2)<0){
					w = t1.intersects(t2);
					if(w==0) continue;
					this.addEdge(t1, t2, w);
				}
			}
		}
	}
}
