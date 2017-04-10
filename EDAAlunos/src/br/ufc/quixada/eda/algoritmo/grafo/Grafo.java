package br.ufc.quixada.eda.algoritmo.grafo;

public class Grafo {
	private int n,m;
	private Aresta arestas[] = null;	

	public Aresta[] getArestas() {
		return arestas;
	}

	public void setArestas(Aresta arestas[]) {
		this.arestas = arestas;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

}
