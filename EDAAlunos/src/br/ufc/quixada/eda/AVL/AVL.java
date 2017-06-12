package br.ufc.quixada.eda.AVL;

public class AVL {
	private NOAVL<?> raiz = null;

	private int altura(NOAVL<?> raiz){
		return(raiz != null ? raiz.getAltura() : 0);
	}

	public NOAVL getRaiz() {
		return raiz;
	}

	public void setRaiz(NOAVL<?> raiz) {
		this.raiz = raiz;
	}

	public void rotacaoDireita(NOAVL<?> raiz){
		NOAVL<?> n, aux;
		n = raiz.getEsq();
		aux = n.getDir();
		n.setDir(raiz);
		raiz.setEsq(aux);
		raiz = n;
	}

	public NOAVL<?> rotacaoEsquerda(NOAVL<?> raiz) {
		NOAVL<?> n, aux;
		n = raiz.getDir();
		aux = n.getEsq();
		n.setEsq(raiz);
		raiz.setDir(aux);
		raiz = n;
		return raiz;
	}

	public void rotacaoDuplaDireita(NOAVL<?> raiz){
		rotacaoDireita(raiz.getDir());
		rotacaoDireita(raiz);
	}

	public NOAVL<?> rotacaoDuplaEsquerda(NOAVL<?> raiz){
		rotacaoEsquerda(raiz.getEsq());
		return rotacaoEsquerda(raiz);
	}

	public int maximo(int a, int b){
		if(a > b){
			return a;
		}
		return b;
	}

	@SuppressWarnings("unused")
	private NOAVL<?> inserir(NOAVL<?> raiz, int chave) {
		if(raiz == null){
			NOAVL no = new NOAVL(chave);
			return no;
		}else if(raiz.getchave() > chave){
			raiz.setEsq(inserir(raiz.getEsq(), chave));
			if(altura(raiz.getEsq())-altura(raiz.getDir()) == 2){
				if(altura(raiz.getEsq().getEsq()) > altura(raiz.getEsq().getDir()))
					rotacaoDireita(raiz);
			}
			else{
				rotacaoDuplaDireita(raiz);
			}
		} else if(raiz.getchave() < chave){
			raiz.setDir(inserir(raiz.getDir(), chave));
		}if(altura(raiz.getEsq()) - altura(raiz.getDir()) == 2){
			if(altura(raiz.getDir().getDir()) > altura(raiz.getDir().getEsq())){
				raiz = rotacaoEsquerda(raiz);
			}
		}
		else {
			raiz = rotacaoDuplaEsquerda(raiz);
		}
	
	raiz.setAltura(maximo(altura(raiz.getDir()), altura(raiz.getEsq()) + 1));
	return raiz;
	}

}


