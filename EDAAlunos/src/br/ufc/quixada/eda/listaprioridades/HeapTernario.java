package br.ufc.quixada.eda.listaprioridades;

public class HeapTernario{
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public HeapTernario(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}

private void subir(int i){
	int j = (i+1)/3;
	if(j>=1){
	 if(vetor[j]<vetor[i]){
	  int aux=vetor[j];
	  vetor[j]=vetor[i];
	  vetor[i]=aux;
	  subir(j);
	  }   
	 }
}

private void descer(int i){
	int j=(3*i)-1;
	if(j<=n){
		if(j+2 <=n){
			
		}
		else(vetor[j+1] > vetor[j] && ((j+1) == n)){
			j++;
			if(vetor[j]>vetor[i]){
				 int aux=vetor[j];
				 vetor[j]=vetor[i];
				 vetor[i]=aux;
			}
		}
	 }
	}
}
