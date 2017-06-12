package br.ufc.quixada.eda.AVL;

public class NOAVL<T> {
	private NOAVL<?> esq;
	private NOAVL<?> dir;
	private int altura, chave;
	NOAVL(int chave){
		esq = null; 
		dir = null;
		setAltura(1);
		this.chave = chave;
	}
	public int getAltura(){
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getchave() {
		return chave;
	}
	public NOAVL<?> getEsq() {
		return esq;
	}
	public NOAVL<?> getDir() {
		return dir;
	}
	public void setDir(NOAVL<?> dir) {
		this.dir = dir;
	}
	public void setEsq(NOAVL<?> esq) {
		this.esq = esq;
	}
	
	
}
