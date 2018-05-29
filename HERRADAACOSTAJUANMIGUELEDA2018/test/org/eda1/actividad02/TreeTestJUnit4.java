package org.eda1.actividad02;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;

public class TreeTestJUnit4 {

	private ArrayList<Item> datos = null;

	public void inicializaEstructura(int size){
		datos = new ArrayList<Item>();
		for (int i=0; i<size; i++)
			for (int j=0; j<size; j++)
				datos.add(new Item(i,j));
	}

	@Test
	public void testItem(){
		Item item1 = new Item(2,3);
		Item item2 = new Item(2,2);
		Item item3 = new Item(3,2);

		assertTrue(item1.compareTo(item2) > 0);
		assertTrue(item1.compareTo(item3) < 0);
		assertTrue(item1.equals(new Item(2,3)));
		assertFalse(item1.equals(new Item(2,4)));

		for (int i=0; i<100; i++){
			item1.incrementaContador();
		}

		assertTrue(item1.getContador() == 101);
		assertEquals(item1.toString(), "(2,3)");
		assertEquals(item2.toString(), "(2,2)");
		assertEquals(item2.getContador(), item3.getContador(), 1);

		item1 = item2 = item3 = null;
	}

	@Test
	public void testHeight() {
		inicializaEstructura(10);

		Collections.shuffle(datos);
		BSTree<Item> tree1 = new BSTree<Item>(datos);

		datos.sort(null);
		BSTree<Item> tree2 = new BSTree<Item>(datos);

		assertEquals(tree2.toString(), datos.toString());

		assertTrue(tree1.size() == 100);
		assertTrue(tree1.contains(new Item(1,1)));
		assertFalse(tree1.contains(new Item(1, 20)));
		assertEquals(tree1.find(new Item(0,0)), new Item(0,0));
		assertNull(tree1.find(new Item(1,50)));

		assertTrue(tree2.height() == 99);
		assertTrue(tree2.height() > tree1.height());

		tree1.clear();
		tree2.clear();
		assertEquals(tree1.height(), tree2.height(), -1);

		tree1 = tree2 = null;
	}

	@Test
	public void testNumberOfLeaves(){
		BSTree<Item> tree = new BSTree<Item>();

		tree.add(new Item(0,3));
		tree.add(new Item(0,2));
		tree.add(new Item(2,0));
		tree.add(new Item(3,0));
		assertTrue(tree.numberOfLeaves()==2);

		tree.add(new Item(1,0));
		assertTrue(tree.numberOfLeaves()==3);

		tree.clear();
		assertTrue(tree.numberOfLeaves()==0);

		tree = null;
	}

	@Test
	public void testFindMinMaxIR(){
		inicializaEstructura(10);

		Collections.shuffle(datos);
		BSTree<Item> tree = new BSTree<Item>(datos);

		assertEquals(tree.findMin(), new Item(0,0));
		assertEquals(tree.findMin(), tree.findMinIterative());
		assertEquals(tree.findMax(), new Item(9,9));
		assertEquals(tree.findMax(), tree.findMaxIterative());

		tree.clear();
		assertTrue(tree.findMin()==null);

		assertTrue(tree.findMinIterative() == tree.findMaxIterative());

		tree = null;
	}

	@Test
	public void toStringLevel(){
		BSTree<Item> tree = new BSTree<Item>();
		tree.add(new Item(0,3));
		tree.add(new Item(0,2));
		tree.add(new Item(2,0));
		tree.add(new Item(3,0));

		assertEquals(tree.toStringLevel(0), "(0,3) ");
		assertEquals(tree.toStringLevel(1), "(0,2) (2,0) ");

		tree.add(new Item(-1,0));

		assertEquals(tree.toStringLevel(2), "(-1,0) (3,0) ");
		tree.clear();
		assertEquals(tree.toStringLevel(3), "");

		tree = null;
	}

	@Test
	public void testPathHeight(){
		inicializaEstructura(10);
		BSTree<Item> tree = new BSTree<Item>(datos);

		assertTrue(tree.pathHeight(new Item(0,9))==9);
		assertTrue(tree.pathHeight(new Item(2,9))==29);
		assertTrue(tree.pathHeight(new Item(0,100))==-1);

		tree.clear();
		assertTrue(tree.pathHeight(new Item(0,9)) == -1);

		tree = null;
	}

	@Test
	public void testCode(){
		BSTree<Item> tree = new BSTree<Item>();
		ArrayList<Item> frase = new ArrayList<Item>();
		tree.add(new Item(0,3));
		tree.add(new Item(0,2));
		tree.add(new Item(2,0));
		tree.add(new Item(3,0));
		tree.add(new Item(1,0));
		tree.add(new Item(0,1));

		frase.add(new Item(3,0));
		frase.add(new Item(0,3));
		frase.add(new Item(1,0));

		assertEquals(tree.code(frase), "011 0 010 ");

		frase.clear();

		frase = tree.decode("0 0 011 010");
		assertEquals(frase.toString(), "[(0,3), (0,3), (3,0), (1,0)]");

		tree.clear();
		frase.clear();
		tree = null;
		frase = null;
	}


	@Test
	public void testpathHeightAllTrees() {
		inicializaEstructura(100); //Probad con 10, 100, 1000


		long tI, tBST, tAVL, tRB;

		BSTree<Item> treeBST = new BSTree<Item>();
		AVLTree<Item> treeAVL = new AVLTree<Item>();
		RBTree<Item> treeRB = new RBTree<Item>();
		int contHeightsBST = 0;
		int contHeightsAVL = 0;
		int contHeightsRB = 0;


		//calculamos la altura de cada uno de los elementos del array en cada tipo de arbol. Idea --> calcular la altura media de sus elementos y comparar

		Collections.shuffle(datos);//Desordenamos el conjunto de datos de entrada...para evitar la degeneracion del BST<T>

		//Volcamos el conjunto de datos de entrada en cada uno de los arboles y calculamos tiempo de ejecucion

		tI = System.nanoTime();
		for (Item it : datos){
			treeBST.add(it);
		}
		tBST = System.nanoTime() - tI;

		tI = System.nanoTime();
		for (Item it : datos){
			treeAVL.add(it);
		}
		tAVL = System.nanoTime() - tI;

		tI = System.nanoTime();
		for (Item it : datos){
			treeRB.add(it);
		}
		tRB = System.nanoTime() - tI;


			//calculamos la altura de cada uno de los elementos del array en cada tipo de arbol. Idea --> calcular la altura media de sus elementos y comparar

		for (int i=0; i<datos.size(); i++){
			contHeightsBST += treeBST.pathHeight(datos.get(i));
			contHeightsAVL += treeAVL.pathHeight(datos.get(i));
			contHeightsRB  += treeRB.pathHeight(datos.get(i));
		}

		System.out.println("Tiempo de ejecucion BST<T>: " + tBST/1e6 + " s");
		System.out.println("Tiempo de ejecucion AVL<T>: " + tAVL/1e6 + " s");
		System.out.println("Tiempo de ejecucion RB<T>: "  + tRB/1e6 + " s");
		System.out.println("Altura del BST<T>: " + treeBST.height());
		System.out.println("Altura del AVL<T>: " + treeAVL.height());
		System.out.println("Altura del RB<T>: "  + treeRB.height());
		System.out.println("Altura media de los elementos contenidos en la estructura BST<T>: " + (float)contHeightsBST/treeBST.size());
		System.out.println("Altura media de los elementos contenidos en la estructura AVL<T>: " + (float)contHeightsAVL/treeAVL.size());
		System.out.println("Altura media de los elementos contenidos en la estructura RB<T>: "  + (float)contHeightsRB/treeRB.size());

		datos.clear();
		treeBST.clear();
		treeAVL.clear();
		treeRB.clear();

		datos = null;
		treeBST = null;
		treeAVL = null;
		treeRB = null;
	}
	//Realizar una grafica en excel con los resultados medios obtenidos con los tres ABB variando el tamaño del del conjunto de entrada
	//Adaptamos el experimento para obtener tiempos de ejecucion al insertar los elementos en cada una de las estructuras...
}
