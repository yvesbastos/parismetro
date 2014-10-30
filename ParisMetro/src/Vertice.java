import java.util.ArrayList;


public class Vertice {
	private ArrayList<Vertice> vizinho;
	boolean baldeacao=false;
	private ArrayList<LinhaMetro> linhas;
	
	public Vertice (LinhaMetro linha1) {
		linhas = new ArrayList<LinhaMetro>();
		linhas.add(linha1);
	}
	
	public Vertice (LinhaMetro linha1, LinhaMetro linha2) {
		linhas = new ArrayList<LinhaMetro>();
		linhas.add(linha1);
		linhas.add(linha2);
	}
	
	public void adicionarVizinho(Vertice vizinho) {
		this.vizinho.add(vizinho);
	}
	
	public void removerVizinho(Vertice vizinho) {
		this.vizinho.remove(vizinho);
	}
}


