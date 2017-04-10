package br.ufc.quixada.eda.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import br.ufc.quixada.eda.algoritmo.grafo.Aresta;
import br.ufc.quixada.eda.algoritmo.grafo.Grafo;

public class EDAUtil {
	/**
	 * Ler o arquivo que cont�m as prioridades iniciais da lista de prioridades.
	 * @param path
	 * @return
	 * @throws IOException
	 */
    public static List<Integer> getDadosIniciais(String path) throws IOException {
        List<Integer> entrada = new ArrayList<Integer>();
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(new FileReader(path)).useDelimiter("\r\n");
		while (scanner.hasNext())
			entrada.add(scanner.nextInt());
		
		scanner.close();
        return entrada;
    }
    //ordenar qualquer lista
    public static void ordenarListaAresta(List<Aresta> arestas){
    	Collections.sort(arestas, new Comparator<Aresta>(){
    		public int compare(Aresta o1, Aresta o2){
    			if(o1.getW() < o2.getW()) return -1;
    			else if(o1.getW() > o2.getW()) return 1;
    			else return 0;
    		}
    	});
    }
    
    public static Grafo lerGrafo(String path) throws IOException{
    	Grafo g = new Grafo();
    	Aresta[] arestas = null;
    	Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(" |\r\n");	
    	
    	if(scanner.hasNext()){
    		g.setN(scanner.nextInt());
    		g.setM(scanner.nextInt());
    		arestas = new Aresta[g.getM()];
    	}
    	int i = 0;
    	while(scanner.hasNext()){
    		arestas[i] = new Aresta(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
    		i++;
    }
	    g.setArestas(arestas);
	    return g;
	}
    
    /**
     * Ler as opera��es que ser�o realizadas na lista de prioridades ap�s a sua cria��o.
     * @param path
     * @return
     * @throws IOException
     */
    public static List<Operacao> getOperacoes(String path) throws IOException {
        List<Operacao> operacoes = new ArrayList<Operacao>();
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(" |\r\n");	
		while (scanner.hasNext())
			operacoes.add(new Operacao(scanner.next(), scanner.nextInt(), scanner.nextInt()));
			
		scanner.close();
        return operacoes;
    }    
}
