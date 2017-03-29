package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

public class HeapTernario{
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public HeapTernario(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	void swap(int a, int b){
		int temp = a;
		a = b;
		b = temp;
	}
	
	public void subir(int i){
		int j = (i+1)/3;
		if(j>=1){
			if(vetor[j] < vetor[i]){
			swap(vetor[j], vetor[i]);
			subir(j);
		  }   
		 }
	}

	public void descer(int i){
		int j=(3*i)-1; //filho da esquerda
			if(j <= n ){
				int temp = 0;
				if(vetor[j+2] <= n){
					if(vetor[j+1] < vetor[j+2])
						temp = j+2;
					else
						temp = j+1;
				}
				if(vetor[temp] < vetor[j]){
					if(vetor[i] < vetor[j]){
						swap(vetor[j], vetor[i]);
						descer(j);
					}
				}
				else if(vetor[i] < vetor[temp]){
					swap(vetor[i], vetor[temp]);
					descer(temp);
				}
			}
			else{
				if(j+1 <= n && vetor[j] < vetor[j+1]){
					j = j+1;
					if(vetor[i] < vetor[j]){
						swap(vetor[i], vetor[j]);
						descer(j);
					}
				}
			}
		}
	
	public void construir(List<Integer> entrada){
		for(int i = 1; i <= entrada.size(); i++){
			vetor[i] = entrada.get(i-1);
			n++;
		}
		for(int j = (n/3)+1; j > 1; j--){
			descer(j);
		}
	}
	
	public int getMaxPrioridade(){
		return vetor[0];
	}
	
	public int remove(){
		int aux = 0;
		if(n >= 1){
			aux= vetor[0];
			int temp = vetor[0];
			vetor[0] = vetor[n-1];
			vetor[n-1] = temp;
			n--;
			descer(0);
		}
		return aux;
	}


	public void inserir(int prioridade){
		if(n+1 <= nMaximo){
			vetor[n+1] = prioridade;
			n++;
			subir(n);
		}
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){
		for(int i = 0; i < n; i++){
			if(vetor[i] == prioridade){
				if(vetor[i] < novaPrioridade){
					vetor[i] = novaPrioridade;
					subir(i);
				}
				else{
					vetor[i] = novaPrioridade;
					descer(i);
				}
				break;
			}
		}
	}
}
