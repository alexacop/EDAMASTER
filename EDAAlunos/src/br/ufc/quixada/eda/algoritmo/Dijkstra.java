package br.ufc.quixada.eda.algoritmo;

import br.ufc.quixada.eda.algoritmo.grafo.Aresta;
import br.ufc.quixada.eda.algoritmo.grafo.Grafo;
import br.ufc.quixada.eda.algoritmo.grafo.ListaAdjacencia;
import br.ufc.quixada.eda.listaprioridades.HeapMinimo;

public class Dijkstra {
	private int origem;
	private int ant[] = null;
	
	public void executar(Grafo g){
		
		HeapMinimo Q = new HeapMinimo(g.getQtVertice());
		Q.contruir(null);
		
		while(!Q.vazia()){
			int u = Q.remove();
			ListaAdjacencia adj = g.getAdj()[u];
			adj.inicializarIterator();
			while(adj.hasNext()){
				Aresta a = adj.next();
				int v = (a.getU() == u ? a.getV() : a.getU());
			
				//relaxamento(u,v)s
			}
			
		}
	}

}
