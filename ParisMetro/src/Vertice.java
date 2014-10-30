import java.util.ArrayList;

/**
 * Classe que representa a estação
 * @author yvesbastos
 *
 */
public class Vertice {
	public ArrayList<Vertice> vizinhos;
	//boolean baldeacao=false;
	public ArrayList<LinhaMetro> linhas;
	int numEstacao = 0;
	
	/**
	 * @author yvesbastos
	 * Construtor.
	 * @param numEstacao numero da estacao (facilita localizacao na matriz)
	 * @param linha1 linha a qual a estacao pertence
	 */
	public Vertice (int numEstacao, LinhaMetro linha1) {
		this.vizinhos = new ArrayList<Vertice>();
		linhas = new ArrayList<LinhaMetro>();
		linhas.add(linha1);
		this.numEstacao=numEstacao;
	}
	
	/**
	 * @author yvesbastos
	 * Construtor para estações onde duas linhas se intersectam 
	 * @param numEstacao numero da estacao (facilita localizacao na matriz)
	 * @param linha1 linha a qual a estacao pertence
	 * @param linha2 linha a qual a estacao pertence
	 */
	public Vertice (int numEstacao, LinhaMetro linha1, LinhaMetro linha2) {
		this.vizinhos = new ArrayList<Vertice>();
		linhas = new ArrayList<LinhaMetro>();
		linhas.add(linha1);
		linhas.add(linha2);
		this.numEstacao=numEstacao;
	}
	
	/**
	 * @author yvesbastos
	 * Função utilizada para criar metrô (configurar estações vizinhas). 
	 * @param vizinho
	 */
	public void adicionarVizinho(Vertice vizinho) {
		this.vizinhos.add(vizinho);
	}
	
	/**
	 * @author yvesbastos
	 *  
	 * @return Retorna lista com vizinhos
	 */
	public ArrayList<Vertice> retornarVizinhos() {
		/*System.out.println("Vizinhos: ");
		for (int i=0; i<vizinhos.size(); i++) {
			System.out.print(vizinhos.get(i).numEstacao + " ");
		}*/
		return vizinhos;
	}
	
	/**
	 * @author yvesbastos
	 * 
	 * @return
	 */
	public int numeroVizinhos() {
		return vizinhos.size();
	}
	
	
}

