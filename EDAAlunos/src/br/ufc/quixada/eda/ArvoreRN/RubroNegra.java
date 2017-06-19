package br.ufc.quixada.eda.ArvoreRN;

public class RubroNegra {
	private No<?> raiz;
	
	public boolean isPreto(No<?> no){
		if(no == null){
			return true;
		}
		else if(no.isCor() == No.preto){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public boolean isVermelho(No<?> no){
		return !isPreto(no);
	}
	
	public void add(int chave){
		raiz = add(raiz, chave);
		raiz.setCor(No.preto);	
	}
	
	private No<?> add(No<?> raiz, int chave){
		if(raiz == null){
			No<?> no = new No<Object>();
			return no;
		
		}if(chave < raiz.getChave()){
			raiz.setEsq(add(raiz.getEsq(),chave));
		
		}else if(chave > raiz.getChave()){
			raiz.setDir(add(raiz.getDir(),chave));
		}else if(isVermelho(raiz.getDir()) && isVermelho(raiz.getEsq()) && isVermelho(raiz.getEsq().getEsq())){
			recolorir(raiz);
		}else if(isVermelho(raiz) && isVermelho(raiz.getDir())){
			raiz = rotacaoEsquerda(raiz);
		}else if(isPreto(raiz.getDir()) && isVermelho(raiz.getDir()) && isVermelho(raiz.getEsq().getEsq())){
			raiz = rotacaoDireita(raiz);
			raiz.setCor(No.preto);
			raiz.getDir().setCor(No.vermelho);
		}
		return raiz;
	}
	
	private int size(No<?> no) {
		return no.tam;
	}
	
	private No<?> rotacaoEsquerda(No<?> n){
		No<?> x = n.getDir();
		n.setDir(x.getEsq());
		x.setEsq(n);
		x.tam = n.tam;
		n.tam = 1 + size(n.getEsq()) + size(n.getDir());
		return x;
		
	}
	
	private No<?> rotacaoDireita(No<?> n){
		No<?> x = n.getEsq();
		n.setEsq(x.getDir());
		x.setDir(n);
		x.tam = n.tam;
		n.tam = 1 + size(n.getEsq()) + size(n.getDir());
		return x;
	}

	

	private void recolorir(No<?> no){
		no.setCor(No.vermelho);
		no.getEsq().setCor(No.preto);
		no.getDir().setCor(No.preto);
	}
	
	public No<?> getRaiz() {
		return raiz;
	}

	public void setRaiz(No<?> raiz) {
		this.raiz = raiz;
	}
}
