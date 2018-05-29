/*
 * @(#)BSTree.java
 */

package org.eda1.actividad02;

import java.util.ArrayList;
import org.eda1.edaAuxiliar.ALStack;
import org.eda1.edaAuxiliar.LinkedQueue;



public class BSTree<T extends Comparable<T>> {

	private BSTNode<T> root;
	private int treeSize;

	/**
	 * Creates an empty binary search tree. All elements inserted into the tree
	 * must implement the <tt>Comparable</tt> interface.
	 */
	public BSTree() {
		root = null;
		treeSize = 0;
	}

	/**
	 * Creates a binary search tree from an ArrayList<T>. All elements inserted into the tree
	 * must implement the <tt>Comparable</tt> interface.
	 */

	public BSTree(ArrayList<T> arr) {
		
	}

	private BSTNode<T> findNode(T item) {
		BSTNode<T> t = root;
		int orderValue;

		while (t != null) {
			orderValue = item.compareTo(t.nodeValue);
			if (orderValue == 0) return t;
			t = (orderValue < 0) ? t.left : t.right;
		}
		return null;
	}

	// delete all the nodes in the tree with root t
	private void deleteTree(BSTNode<T> current) {
		if (current == null) return;
		deleteTree(current.left);
		deleteTree(current.right);
		current = null;
	}


	/**
	 * Adds the specified item to this tree if it is not already present.
	 *
	 * @param item
	 *            element to be added to this tree.
	 * @return <tt>true</tt> if the tree did not already contain the specified
	 *         element.
	 */
	public boolean add(T item) {
		// t is current node in traversal, parent the previous node
		BSTNode<T> current = root, parent = null, newNode;
		int orderValue = 0;

		while (current != null) {
			parent = current;
			orderValue = item.compareTo(current.nodeValue);
			if (orderValue == 0) return false; //El elemento ya existe
			current = (orderValue < 0) ? current.left : current.right;
		}

		// create the new node
		newNode = new BSTNode<T>(item);

		if (parent == null)
			root = newNode;
		else if (orderValue < 0)
			parent.left = newNode;
		else
			parent.right = newNode;
		treeSize++;

		// we added a node to the tree
		return true;
	}

	/**
	 * Removes all of the elements from this tree. The resulting tree is empty
	 * after the method executes.
	 */
	public void clear() {
		treeSize = 0;
		deleteTree(root);
		root = null;
	}

	/**
	 * Returns <tt>true</tt> if this tree contains the specified element.
	 *
	 * @param item
	 *            the object to be checked for containment in this tree.
	 * @return <tt>true</tt> if this tree contains the specified element.
	 */
	public boolean contains(T item) {
		return findNode(item) == null ? false : true;
	}

	/**
	 * Returns <tt>true</tt> if this tree contains no elements.
	 *
	 * @return <tt>true</tt> if this tree contains no elements.
	 */
	public boolean isEmpty() {
		return treeSize == 0;
	}


	/**
	 * Returns the number of elements in this tree.
	 *
	 * @return the number of elements in this tree.
	 */
	public int size() {
		return treeSize;
	}

	/**
	 * Returns an ArrayList containing all of the elements in this tree. The order
	 * of elements in the array is in order...
	 *
	 * @return an array containing all of the elements in this tree.
	 */

	private void toArrayList(BSTNode<T> current, ArrayList<T> arr){
		//...
	}

	public ArrayList<T> toArrayList(){
		ArrayList<T> arr = new ArrayList<T>();
		toArrayList(root, arr);
		return arr;
	}

	/**
	 * Searches for the specified item in the tree and returns the value of the
	 * node that matches item as a key.
	 *
	 * @param item
	 *            serves as a key to locate an element in the tree..
	 * @return the value of the node that corresponds to item as a key or
	 *         <tt>null</tt> if the element is not found.
	 */
	public T find(T item) {
		BSTNode<T> t = findNode(item);
		return t == null ? null : t.nodeValue;
	}


	@Override
	public String toString(){
		return toArrayList().toString();
	}
	
	/**
	 * Returns a string that displays the elements in the binary tree using the
	 * preorder (NLR) scan. The description is a listing of elements separated
	 * by two blanks.
	 *
	 * @param t
	 *            a <tt>TNode</tt> that designates the root of the tree.
	 * @return string that contains the list of elements in the array.
	 */
	private String toStringPreorder(BSTNode<T> current) {
		String s = "";
		if (current == null) return "";
		s += current.nodeValue + "  "; 
		s += toStringPreorder(current.left); 
		s += toStringPreorder(current.right);
		return s;
	}

	public String toStringPreorder() {
		return toStringPreorder(root);
	}

	private String toStringInorder(BSTNode<T> current) {
		String s = "";
		if (current == null) return "";
		s += toStringInorder(current.left); 
		s += current.nodeValue + "  "; 
		s += toStringInorder(current.right);
		return s;
	}

	public String toStringInorder() {
		return toStringInorder(root);
	}

	private String toStringPostorder(BSTNode<T> current) {
		String s = "";
		if (current == null) return "";
		s += toStringPostorder(current.left); 
		s += toStringPostorder(current.right);
		s += current.nodeValue + "  "; 
		return s;
	}

	public String toStringPostorder() {
		return toStringPostorder(root);
	}

	private String toStringLevel(BSTNode<T> t, int currentLevel, int level){
		//...
	}

	public String toStringLevel(int level){
		return toStringLevel(root, 0, level);
	}

	public String toStringBreadthFirstTraversal() {
		LinkedQueue<BSTNode<T>> q = new LinkedQueue<BSTNode<T>>();
		BSTNode<T> p;
		String s = "";

		if (root == null) return "";
		q.push(root);

		while (!q.isEmpty()) {
			p = q.pop();
			s += p.nodeValue + "  ";

			if (p.left != null)
				q.push(p.left);
			if (p.right != null)
				q.push(p.right);
		}
		return s;
	}
	
	public String toStringIterativePreorder() {
		ALStack<BSTNode<T>> st = new ALStack<BSTNode<T>>();
		BSTNode<T> p;
		String s = "";
		if (root == null) return "";
		st.push(root);
		while (!st.isEmpty()) {
			p = st.peek();
			st.pop();
			s += p.nodeValue + "  ";
			if (p.right != null)
				st.push(p.right);
			if (p.left != null)
				st.push(p.left);
		}
		return s;
	}

	
	public String toStringIterativeInorder() {
		ALStack<BSTNode<T>> st = new ALStack<BSTNode<T>>();
		BSTNode<T> p = root;
		String s = "";

		while (p != null) {
			while (p != null) {
				if (p.right != null)
					st.push(p.right);
				st.push(p);
				p = p.left;
			}
			p = st.peek();
			st.pop();

			while (!st.isEmpty() && p.right == null) {
				s += p.nodeValue + "  ";
				p = st.peek();
				st.pop();
			}
			s += p.nodeValue + "  ";
			if (!st.isEmpty()) {
				p = st.peek();
				st.pop();
			} else
				p = null;
		}
		return s;
	}


	public String toStringIterativePostorder() {
		ALStack<BSTNode<T>> st = new ALStack<BSTNode<T>>();
		BSTNode<T> p = root;
		BSTNode<T> q = root;
		String s = "";

		while (p != null) {
			for (; (p.left != null); p = p.left)
				st.push(p);
			while ((p != null) && ((p.right == null) || (p.right == q))) {
				s += p.nodeValue + "  ";
				q = p;
				if (st.isEmpty())
					return s;
				p = st.peek();
				st.pop();
			}
			st.push(p);
			p = p.right;
		}
		return s;
	}

	public String toStringIterativePreorderEasy() {
		ALStack<BSTNode<T>> st = new ALStack<BSTNode<T>>();
		BSTNode<T> p = root;
		String s = "";

		if (p != null) {
			st.push(p);
			while (!st.isEmpty()) {
				p = st.peek();
				st.pop();
				if ((p.left == null) && (p.right == null))
					s += p.nodeValue + "  ";
				else {
					if (p.right != null)
						st.push(p.right);
					if (p.left != null)
						st.push(p.left);
					BSTNode<T> aux = new BSTNode<T>(p.nodeValue);
					st.push(aux);
				}
			}
		}
		return s;
	}

	public String toStringIterativeInorderEasy() {
		ALStack<BSTNode<T>> st = new ALStack<BSTNode<T>>();
		BSTNode<T> p = root;
		String s = "";

		if (p != null) {
			st.push(p);
			while (!st.isEmpty()) {
				p = st.peek();
				st.pop();
				if ((p.left == null) && (p.right == null))
					s += p.nodeValue + "  ";
				else {
					if (p.right != null)
						st.push(p.right);
					BSTNode<T> aux = new BSTNode<T>(p.nodeValue);
					st.push(aux);
					if (p.left != null)
						st.push(p.left);
				}
			}
		}
		return s;
	}

	public String toStringIterativePostorderEasy() {
		ALStack<BSTNode<T>> st = new ALStack<BSTNode<T>>();
		BSTNode<T> p = root;
		String s = "";

		if (p != null) {
			st.push(p);
			while (!st.isEmpty()) {
				p = st.peek();
				st.pop();
				if ((p.left == null) && (p.right == null))
					s += p.nodeValue + "  ";
				else {
					BSTNode<T> aux = new BSTNode<T>(p.nodeValue);
					st.push(aux);
					if (p.right != null)
						st.push(p.right);
					if (p.left != null)
						st.push(p.left);
				}
			}
		}
		return s;
	}

	
	private int height(BSTNode<T> current) {
		//...
	}

	public int height() {
		return height(root);
	}

	private int numberOfLeaves(BSTNode<T> current) {
		//...
	}

	public int numberOfLeaves() {
		return numberOfLeaves(root);
	}

	private BSTNode<T> findMin(BSTNode<T> current) {
		//...
	}

	public T findMin() {
		if (this.root == null) return null;
		return findMin(root).nodeValue;
	}

	
	public T findMinIterative() {
		BSTNode<T> current = root;
		//...
		return current.nodeValue;
	}

	
	private BSTNode<T> findMax(BSTNode<T> current) {
		//...
	}

	public T findMax() {
		if (this.root == null) return null;
		return findMax(root).nodeValue;
	}
	
	public T findMaxIterative() {
		BSTNode<T> current = root;
		//...
		return current.nodeValue;
	}
	
	private int pathHeight(BSTNode<T> current, T item, int altura){
		//...
	}

	public int pathHeight(T item){
		 return pathHeight(root, item, 0);
	}

	private String displayTree(BSTNode<T> current, int level) {
		String aux = "";
		if (current == null) return "";

		aux += current.right == null ? "" : displayTree(current.right, level+1);
		for (int i = 0; i < level; i++)	aux += "     ";
		aux += current.toString() + "\n";
		aux += current.left == null ? "" : displayTree(current.left, level + 1);
		return aux;
	}

	public String displayTree() {
		return displayTree(root, 0);
	}


	private String code(BSTNode<T> current, T item, String codigo){
		//...
	}

	public String code(ArrayList<T> frase){
		String result="";
		for (int i=0; i<frase.size(); i++)
			result += code(root, frase.get(i),"0") + " ";
		return result;
	}

	private T decode(BSTNode<T> current, String codigo){
		//...
		return current == null ? null : current.nodeValue;
	}

	public ArrayList<T> decode(String mensaje){
		String[] codigo = mensaje.split(" ");
		ArrayList<T> result = new ArrayList<T>();
		for (int i=0; i<codigo.length; i++)
			result.add(decode(root, codigo[i]));
		return result;
	}

	// declares a binary search tree node object
	private static class BSTNode<T extends Comparable<T>> implements Comparable<BSTNode<T>> {
		// BSTNode is used to implement the binary search tree class
		// making the data public simplifies building the class functions

		// node data
		T nodeValue;
		// child links and link to the node's parent
		BSTNode<T> left, right;

		// constructor that initializes the value and sets
		// the link fields left and right to null
		public BSTNode(T item) {
			nodeValue = item;
			left = null;
			right = null;
		}

		@Override
		public int compareTo(BSTNode<T> o) {
			return this.nodeValue.compareTo(o.nodeValue);
		}

		@Override
		public String toString(){
			return nodeValue.toString();
		}
	}
}