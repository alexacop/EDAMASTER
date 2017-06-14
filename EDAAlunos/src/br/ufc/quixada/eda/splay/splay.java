package br.ufc.quixada.eda.splay;

public class splay<T> {
	private NO<T> raiz = null;

	private NO<T> splay(NO<T> raiz, int key){
		if(raiz == null)
			return null;
		if(raiz.getKey() == key) 
			return raiz;
		if(key < raiz.getKey()){
			if(raiz.getLeft() != null){
				raiz.setLeft(splay(raiz.getLeft(), key));
				raiz = rotacaoDireita(raiz);
			}
		}else if (key > raiz.getKey()){
			if(raiz.getRight() != null){
				raiz.setRight(splay(raiz.getRight(),key));
				raiz = rotacaoEsquerda(raiz);
			}
		}
		return raiz;
	}
	
	NO<T> rotacaoDireita(NO<T> no){
		NO<T> tmp = no.getLeft();
		no.setLeft(no.getLeft().getRight());
		tmp.setRight(no);
		return tmp;

	}

	NO<T> rotacaoEsquerda(NO<T> no){
		NO<T> tmp = no.getRight();
		no.setLeft(no.getRight().getLeft());
		tmp.setLeft(no);
		return tmp;

	}

	public NO<T> buscar(int key){
		raiz = splay(raiz,key);
		if(raiz != null && raiz.getKey() == key)
			return raiz;
		return null;
	}

	public void inserir(int key){
		raiz = splay(raiz, key);
		if(raiz == null || raiz.getKey() == key) 
			return;
		NO<T> tmp = new NO<T>();
		tmp.setRight(raiz);
		tmp.setLeft(raiz.getLeft());
		raiz = tmp;
	}

	public void remover(int key){
		raiz = splay(raiz, key);
		if(raiz.getKey() != key || raiz == null )
			return;
		else{
			NO<T> tmp = splay(raiz.getLeft(), key);
			tmp.setRight(raiz.getRight());
			raiz = tmp;
		}
	}


	public NO<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NO<T> raiz) {
		this.raiz = raiz;
	}

}
