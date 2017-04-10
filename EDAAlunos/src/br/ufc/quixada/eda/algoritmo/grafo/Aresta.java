package br.ufc.quixada.eda.algoritmo.grafo;

public class Aresta {
	private int u,v;
	private double w;
	
	public Aresta(int u, int v, double w) {
		super();
		this.u = u;
		this.v = v;
		this.w = w;
	}
	public int getU() {
		return u;
	}
	public void setU(int u) {
		this.u = u;
	}
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	public double getW() {
		return w;
	}
	public void setW(double w) {
		this.w = w;
	}
}
