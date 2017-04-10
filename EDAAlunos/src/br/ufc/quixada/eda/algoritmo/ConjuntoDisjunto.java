package br.ufc.quixada.eda.algoritmo;

public class ConjuntoDisjunto {
	private int pai[] = null;
	private int ordem[] = null;
	private int n = 0;


public ConjuntoDisjunto(int n) {
	this.n = n;
	pai = new int[n+1];
	ordem = new int[n+1];
}

public void Make_set(int i){
	pai[i] = i;
	ordem[i] = 0;
}

public void Make_set_all(){
	for(int i = 1; i <= n; i++)
		Make_set(i);
}

public int Find_set1(int v) {
	if(v == pai[v]){
		return v;
	} else
		return Find_set1(pai[v]);
	
}

public int Find_set(int v) {
	if(v == pai[v])	
		return v;
	else{
		pai[v] = Find_set(pai[v]);
		return pai[v];
	}
}

public void Link_set1(int v, int u) {
	pai[v] = u;
}

public void Link_set(int v, int u) {
	if(ordem[v] < ordem[u])
		pai[v] = u;
	else{
		pai[u] = v;
		if(ordem[u] == ordem[v])
			ordem[v]++;
	}
}

public void Union(int v, int u){
	Link_set(Find_set(v), Find_set(u));
	}

}

