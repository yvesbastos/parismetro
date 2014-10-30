import java.util.ArrayList;

/**
 * 
 * @author yvesbastos
 *
 */
public class ParisMetro {
	//estacoes do metrô 	
	public Vertice e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14;
	
	public ParisMetro() {
		setVertices();
	}
	
	/**
	 * Monta hierarquia do metrô. Informações estáticas e extraídas do mapa.
	 */
	private void setVertices() {
		 e1 = new Vertice(1, LinhaMetro.Azul);
		 e2 = new Vertice(2, LinhaMetro.Azul, LinhaMetro.Amarela);
		 e3 = new Vertice(3, LinhaMetro.Azul, LinhaMetro.Vermelha);
		 e4 = new Vertice(4, LinhaMetro.Azul, LinhaMetro.Verde);
		 e5 = new Vertice(5, LinhaMetro.Azul, LinhaMetro.Amarela);
		 e6 = new Vertice(6, LinhaMetro.Azul);
		 e7 = new Vertice(7, LinhaMetro.Amarela);
		 e8 = new Vertice(8, LinhaMetro.Amarela, LinhaMetro.Verde);
		 e9 = new Vertice(9, LinhaMetro.Amarela, LinhaMetro.Vermelha);
		 e10 = new Vertice(10, LinhaMetro.Amarela);
		 e11 = new Vertice(11, LinhaMetro.Vermelha);
		 e12 = new Vertice(12, LinhaMetro.Verde);
		 e13 = new Vertice(13, LinhaMetro.Verde, LinhaMetro.Vermelha);
		 e14 = new Vertice(14, LinhaMetro.Verde);
		
		e1.adicionarVizinho(e2);
		
		e2.adicionarVizinho(e1);
		e2.adicionarVizinho(e3);
		e2.adicionarVizinho(e9);
		e2.adicionarVizinho(e10);
		
		e3.adicionarVizinho(e2);
		e3.adicionarVizinho(e4);
		e3.adicionarVizinho(e9);
		e3.adicionarVizinho(e13);
		
		e4.adicionarVizinho(e3);
		e4.adicionarVizinho(e5);
		e4.adicionarVizinho(e8);
		e4.adicionarVizinho(e13);
		
		e5.adicionarVizinho(e4);
		e5.adicionarVizinho(e6);
		e5.adicionarVizinho(e7);
		e5.adicionarVizinho(e8);
		
		e6.adicionarVizinho(e5);
		
		e7.adicionarVizinho(e5);
		
		e8.adicionarVizinho(e4);
		e8.adicionarVizinho(e5);
		e8.adicionarVizinho(e9);
		e8.adicionarVizinho(e12);
		
		e9.adicionarVizinho(e2);
		e9.adicionarVizinho(e3);
		e9.adicionarVizinho(e8);
		e9.adicionarVizinho(e11);
		
		e10.adicionarVizinho(e2);
		
		e11.adicionarVizinho(e9);
		
		e12.adicionarVizinho(e8);
		
		e13.adicionarVizinho(e3);
		e13.adicionarVizinho(e4);
		e13.adicionarVizinho(e14);
		
		e14.adicionarVizinho(e13);
	}
}
