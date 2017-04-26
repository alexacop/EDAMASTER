package br.ufc.quixada.eda.algoritmo.grafo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListaAdjacencia implements Iterator<Aresta> {
	private List<Aresta> lista = null;
	private int posicao = 0;

	public ListaAdjacencia() {
		lista = new ArrayList<Aresta>();
	}

	public void add(Aresta a) {
		lista.add(a);
	}

	public void teste() {
		for (int i = 0; i < lista.size(); i++) {
			Aresta aa = lista.get(i);
		}
	}

	public void inicializarIterator() {
		posicao = 0;
	}

	public boolean hasNext() {
		return (posicao < lista.size());
	}

	public Aresta next() {
		Aresta aa = lista.get(posicao);
		posicao++;
		return aa;
	}
}
