package tpoPackage;

import java.util.ArrayList;

public class BFS {

	public static ArrayList<Integer> bfsGrafo(GrafoDinamic grafo, NodoGrafo origen) {
		ArrayList<Integer> nodos = new ArrayList<Integer>();
		visitarNodobfs(origen, nodos);
		return nodos;
	}

	public static void visitarNodobfs(NodoGrafo nodo, ArrayList<Integer> lista) {
		NodoArista aux = nodo.lista;
		if (!nodo.Visitado) {
			nodo.Visitado = true;
			lista.add(nodo.valor);
		} 
		while (aux != null) {
			if (!aux.apunta.Visitado) {
				aux.apunta.Visitado = true;
				lista.add(aux.apunta.valor);
				System.out.println("Nodo: " + aux.apunta.valor + " Padre: " + aux.origen + " | ");
				
			} 
			aux = aux.sig;
		} 
		aux = nodo.lista;
		while (aux != null) {
			if (!aux.Visitado) {
				aux.Visitado = true;
				visitarNodobfs(aux.apunta, lista);
			}
			aux = aux.sig; 
		}

	}

	public static void main(String[] args) {
		GrafoDinamic grafo = new GrafoDinamic();

		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);
		grafo.agregarVertice(7);
		grafo.agregarVertice(8);

		grafo.agregarArista(1, 2, 0);
		grafo.agregarArista(2, 1, 0);

		grafo.agregarArista(1, 5, 0);
		grafo.agregarArista(5, 1, 0);

		grafo.agregarArista(2, 6, 0);
		grafo.agregarArista(6, 2, 0);

		grafo.agregarArista(6, 3, 0);
		grafo.agregarArista(3, 6, 0);

		grafo.agregarArista(6, 7, 0);
		grafo.agregarArista(7, 6, 0);

		grafo.agregarArista(7, 3, 0);
		grafo.agregarArista(3, 7, 0);

		grafo.agregarArista(7, 4, 0);
		grafo.agregarArista(4, 7, 0);

		grafo.agregarArista(7, 8, 0);
		grafo.agregarArista(8, 7, 0);

		grafo.agregarArista(3, 4, 0);
		grafo.agregarArista(4, 3, 0);

		grafo.agregarArista(4, 8, 0);
		grafo.agregarArista(8, 4, 0);

		NodoGrafo origen = grafo.encontrarNodo(2);

		System.out.println("Origen: " + origen.valor);
		bfsGrafo(grafo, origen);
	}
}