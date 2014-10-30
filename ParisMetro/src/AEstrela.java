import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author yvesbastos
 *
 */
public class AEstrela {
	
	private float [] [] matrizDistancias;
	private ArrayList<Vertice> caminho;
	//private int tempoTrajeto;
	
	private ArrayList<Vertice> closedList;
    private SortedNodeList openList;
    //private Path shortestPath;
	
    /**
	 * Construtor. Recebe como parâmetro o caminho do .txt com as distancias entre
	 * estações em forma de matriz.
	 * @param caminhoArquivo
	 */
	public AEstrela(String caminhoArquivo) {		
		Distancias computarDistancias = new Distancias();
		matrizDistancias = computarDistancias.definirDistancias(caminhoArquivo);
		
		caminho = new ArrayList<Vertice>();
		closedList = new ArrayList<Vertice>();
        openList = new SortedNodeList();
	}
	
	/**
	 * Função que recebe a origem, destino e calcula o trajeto. A idéia é adicionar o caminho percorrido
	 * no ArrayList caminho (se alguém tiver uma idéia melhor, muda o método). 
	 * @param vInicial
	 * @param vFinal
	 */
	public int aEstrela(Vertice estacaoInicial, Vertice estacaoDestino) {
		 closedList.clear();
         openList.limpar();
         openList.adicionar(estacaoInicial);
         caminho.add(estacaoInicial);
         
         float custoAteAqui=0;
            
         //enquanto nao atingir destino
         while(openList.tamanho() != 0) {

             //pegar vertice mais próximo ao destino da fronteira (heuristica)
             Vertice verticeAtual = openList.pegarMaisProximoAoDestino(estacaoDestino);
             custoAteAqui = matrizDistancias[estacaoInicial.numEstacao-1][verticeAtual.numEstacao-1];
             
             
             // o atual é o destino? Se sim, acabou. 
             if(verticeAtual.numEstacao == estacaoDestino.numEstacao) {
            	 	if (!(caminho.contains(verticeAtual))) {
            	 		caminho.add(verticeAtual);
            	 	}
                    imprimirTrajeto();
                    openList.remover(verticeAtual);
                    closedList.add(verticeAtual);
                     return 1;
             }
             
            openList.remover(verticeAtual);
            closedList.add(verticeAtual);
            
          //verificar entre os vizinhos qual será o escolhido
            float distanciaMelhorVizinho=1000;
            
            Vertice melhorVizinho=estacaoDestino;
            for(Vertice vizinho : verticeAtual.retornarVizinhos()) {                    
            	//if we have already searched this Node, don't bother and continue to the next one 
                    if (closedList.contains(vizinho))
                    	continue;
                    float distanciaVizinhoAteDestino = ((custoAteAqui + matrizDistancias[verticeAtual.numEstacao-1][vizinho.numEstacao-1]) + custoBaldeacao(verticeAtual, vizinho) + matrizDistancias[vizinho.numEstacao-1][estacaoDestino.numEstacao-1]);
                    
                    if(!openList.possui(vizinho)) {
                        openList.adicionar(vizinho);
                    }	
                    
                    //(distanciaVizinhoAteDestino < distanciaAtualAteDestino) &&
                    if( distanciaVizinhoAteDestino < distanciaMelhorVizinho) {
                        System.out.println("Vizinho atual " + vizinho.numEstacao + ": " + distanciaVizinhoAteDestino + " < Melhor vizinho " + melhorVizinho.numEstacao + ": " + distanciaMelhorVizinho);
                    	melhorVizinho = vizinho;
                    	distanciaMelhorVizinho=distanciaVizinhoAteDestino;
                        System.out.println("melhor vizinho escolhido: " + melhorVizinho.numEstacao);
                    	   	
                    } else {
                    	System.out.println("entrou no else");
                    	openList.remover(vizinho);
                    	closedList.add(vizinho);
                    }
            }
            caminho.add(melhorVizinho);
            System.out.println("melhor vizinho adicionado: " + melhorVizinho.numEstacao);
            

         }
         return 0;
	}
	
	/**
	 * Verifica se é necessário que o usuário faça uma baldeação entre as duas estações
	 * @param v1
	 * @param v2
	 * @return
	 */
	public float custoBaldeacao(Vertice v1, Vertice v2) {
		for (int i=0; i<v1.linhas.size(); i++) {
			if (v2.linhas.contains(v1.linhas.get(i))) {
				//sem baldeacao
				return 0;
			}
		}
		return (float) 0.0667;// baldeacao;
	}
	
	/**
	 * @author yvesbastos
	 * Função simplificada e provisória para mostrar o trajeto escolhido. 
	 * 
	 */
	public void imprimirTrajeto() {
		System.out.println("Caminho: ");
		for (int i=0; i<caminho.size(); i++) {
			System.out.print(caminho.get(i).numEstacao + " ");
		}
	}
	 
	 
	/**
	 * Classe para organizar fronteira
	 * @author yvesbastos
	 *
	 */
	private class SortedNodeList {

        private ArrayList<Vertice> lista = new ArrayList<Vertice>();

        public Vertice pegarMaisProximoAoDestino(Vertice goal) {
        	float distancia=1000;
        	int tIndex=-1;
        	
        	for (int i=0; i<lista.size(); i++) {
        		//System.out.println("index: " + list.get(i).numEstacao);
        		float tempDist = matrizDistancias[lista.get(i).numEstacao-1][goal.numEstacao-1]; 
        		if (tempDist<distancia) {
        			distancia = tempDist;
        			tIndex=i;
        		}
        	}
                return lista.get(tIndex);
        }
        
        public void limpar() {
                lista.clear();
        }

        public void adicionar(Vertice node) {
                lista.add(node);
        }

        public void remover(Vertice n) {
                lista.remove(n);
        }

        public int tamanho() {
                return lista.size();
        }

        public boolean possui(Vertice n) {
                return lista.contains(n);
        }
}
}

/*if (current.numEstacao == goal.numEstacao) {
	if (!(caminho.contains(current))) {
		caminho.add(current);
	}
 imprimirTrajeto();
 openList.remove(current);
 closedList.add(current);
  return 1;
}*/
