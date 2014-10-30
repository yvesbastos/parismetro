import java.util.ArrayList;


public class Vertice {
	public ArrayList<Vertice> vizinhos;
	boolean baldeacao=false;
	private ArrayList<LinhaMetro> linhas;
	int numEstacao = 0;
	
	public Vertice (int numEstacao, LinhaMetro linha1) {
		this.vizinhos = new ArrayList<Vertice>();
		linhas = new ArrayList<LinhaMetro>();
		linhas.add(linha1);
		this.numEstacao=numEstacao;
	}
	
	public Vertice (int numEstacao, LinhaMetro linha1, LinhaMetro linha2) {
		this.vizinhos = new ArrayList<Vertice>();
		linhas = new ArrayList<LinhaMetro>();
		linhas.add(linha1);
		linhas.add(linha2);
		this.numEstacao=numEstacao;
	}
	
	public void adicionarVizinho(Vertice vizinho) {
		this.vizinhos.add(vizinho);
	}
	
	public void removerVizinho(Vertice vizinho) {
		this.vizinhos.remove(vizinho);
	}
	
	public int numeroVizinhos() {
		return vizinhos.size();
	}
}


