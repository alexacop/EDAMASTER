package br.ufc.quixada.eda.algoritmo;

import br.ufc.quixada.eda.algoritmo.grafo.Aresta;
import br.ufc.quixada.eda.algoritmo.grafo.Grafo;

public class ArvoreGeradoraMinima{

	private void quickSort(Aresta[] arestas,int ini, int fim){
		if (ini < fim) {
            int posicaoPivo = particiona(arestas,ini, fim);
            quickSort(arestas,ini, posicaoPivo - 1);
            quickSort(arestas,posicaoPivo + 1, fim);
     }

		}
	
	private int particiona(Aresta[] arestas,int p, int r){		
		 int pivo = p;
         int ini = p + 1;
         int fim = r;
         while (ini <= fim) {
                if (arestas[ini].getW() <= arestas[pivo].getW())
                       ini++;
                else if (arestas[pivo].getW() < arestas[fim].getW())
                       fim--;
                else {
                       Aresta aux = arestas[ini];
                       arestas[ini] = arestas[fim];
                       arestas[fim] = aux;
                       ini++;
                       fim--;
                }
         }
         arestas[p] = arestas[fim];
         arestas[fim] = arestas[pivo];
         return fim;
	}
	
	public Aresta[] Kruskal(Grafo g){
		Aresta[] solucao = new Aresta[g.getN()-1];
		ConjuntoDisjunto conj = new ConjuntoDisjunto(g.getN());
		for(int i = 1; i <= g.getN(); i++){
			conj.Make_set(i);
		}
		quickSort(g.getArestas(), 0, g.getArestas().length-1);
		int i = 0;
		for(int j = 0; j < g.getM(); j++){
			Aresta e = g.getArestas()[j];
			if(conj.Find_set(e.getV()) != conj.Find_set(e.getU())){
				solucao[i] = e;
				i++;
				conj.Union(e.getV(), e.getU());
			}
		}
		return solucao;
	}
}
