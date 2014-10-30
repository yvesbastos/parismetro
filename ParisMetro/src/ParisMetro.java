import java.util.ArrayList;


public class ParisMetro {
	//linhas do metrô 	
	private static final LinhaMetro Azul = LinhaMetro.Azul;
	private static final LinhaMetro Vermelha = LinhaMetro.Vermelha;
	private static final LinhaMetro Amarela = LinhaMetro.Amarela;
	private static final LinhaMetro Verde = LinhaMetro.Verde;
	public Vertice e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14;
	
	public ParisMetro() {
		setVertices();
	}
	
	private void setVertices() {
		 e1 = new Vertice(1, Azul);
		 e2 = new Vertice(2, Azul, Amarela);
		 e3 = new Vertice(3, Azul, Vermelha);
		 e4 = new Vertice(4, Azul, Verde);
		 e5 = new Vertice(5, Azul, Amarela);
		 e6 = new Vertice(6, Azul);
		 e7 = new Vertice(7, Amarela);
		 e8 = new Vertice(8, Amarela, Verde);
		 e9 = new Vertice(9, Amarela, Vermelha);
		 e10 = new Vertice(10, Amarela);
		 e11 = new Vertice(11, Vermelha);
		 e12 = new Vertice(12, Verde);
		 e13 = new Vertice(13, Verde, Vermelha);
		 e14 = new Vertice(14, Verde);
		
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
		
		e8.adicionarVizinho(e5);
		e8.adicionarVizinho(e9);
		
		e9.adicionarVizinho(e8);
		e9.adicionarVizinho(e2);
		
		e10.adicionarVizinho(e2);
		
		e11.adicionarVizinho(e9);
		
		e12.adicionarVizinho(e8);
		
		e13.adicionarVizinho(e4);
		e13.adicionarVizinho(e14);
		
		e14.adicionarVizinho(e13);
	}
}
