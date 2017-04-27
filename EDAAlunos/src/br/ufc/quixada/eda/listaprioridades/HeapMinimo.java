package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

/**
 * Implementa a lista de prioridade usando Heap Maximo.
 * 
 * @author fabio
 *
 */
public class HeapMinimo {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int id[] = null;
	private int n = 0;

	public HeapMinimo(int Nmaximo) {
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
		id = new int[Nmaximo];
	}
	
	public boolean vazia(){
		return (n == 0);
	}

	private void subir(int i) {
		int j = i / 2;
		if (j >= 1) {
			if (vetor[i] < vetor[j]) {
				int aux = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux;

				aux = id[i];
				id[i] = id[j];
				id[j] = aux;

				subir(j);
			}
		}
	}

	private void descer(int i) {
		int j = 2 * i;
		if (j <= n) {
			if (vetor[j + 1] < vetor[j] && j + 1 <= n)
				j++;

			if (vetor[i] < vetor[j]) {
				int aux = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux;

				aux = id[i];
				id[i] = id[j];
				id[j] = aux;

				descer(j);
			}
		}
	}

	public void contruir(List<Integer> entrada) {
		for (int i = 1; i < entrada.size(); i++) {
			vetor[i] = entrada.get(i - 1);
			id[i] = i;
			n++;
		}
		for (int j = n / 2; j >= 1; j--) {
			descer(j);
		}

	}

	public int getMaximaPrioridade() {
		return vetor[0];
	}

	public int remove() {
		int aux = 0;
		if (n >= 1) {
			id[0] = id[n-1];
			aux = vetor[0];
			int aux2 = vetor[0];
			vetor[0] = vetor[n - 1];
			vetor[n - 1] = aux2;
			n--;
			descer(0);
		}
		return aux;
	}

	public void inserir(int prioridade) {
		if (n + 1 <= nMaximo) {
			vetor[n + 1] = prioridade;
			n++;
			subir(n);
		}
	}

	public void alterarPrioridade(int prioridade, int novaPrioridade) {
		for (int i = 0; i < n; i++) {
			if (vetor[i] == prioridade && id[i] != prioridade) {
				if (vetor[i] < novaPrioridade) {
					vetor[i] = novaPrioridade;
					subir(i);
				} else {
					vetor[i] = novaPrioridade;
					descer(i);
				}
				break;
			}
		}
	}
}
