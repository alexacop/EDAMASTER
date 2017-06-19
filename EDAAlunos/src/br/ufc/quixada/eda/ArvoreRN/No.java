package br.ufc.quixada.eda.ArvoreRN;

public class No<T> {
	int tam;
	private No<?> esq,dir;
	private int chave;
	private boolean cor;
	public static final boolean preto = true;
	public static final boolean vermelho = false;
	
	public No<?> getEsq() {
		return esq;
	}
	public void setEsq(No<?> esq) {
		this.esq = esq;
	}
	public No<?> getDir() {
		return dir;
	}
	public void setDir(No<?> dir) {
		this.dir = dir;
	}
	
	public int getChave() {
		return chave;
	}
	public void setChave(int chave) {
		this.chave = chave;
	}
	public boolean isCor() {
		return cor;
	}
	public void setCor(boolean cor) {
		this.cor = cor;
	}
	
}
