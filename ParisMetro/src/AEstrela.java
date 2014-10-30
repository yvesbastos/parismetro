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
	
	private int [] [] matrizDistancias;
	private ArrayList<Vertice> caminho;
	
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
		//computarDistancias.mostrarMatriz();
		
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
	public int/*nao deve retornar int; provisorio*/ aEstrela(Vertice start, Vertice goal) {
		 closedList.clear();
         openList.clear();
         openList.add(start);
        int custoAteAqui=0;
         caminho.add(start);
         //while we haven't reached the goal yet
         while(openList.size() != 0) {

             //get the first Node from non-searched Node list, sorted by lowest distance from our goal as guessed by our heuristic
             Vertice current = openList.getClosest(goal);
             //int custoAteAqui = 0;
             custoAteAqui = matrizDistancias[start.numEstacao-1][current.numEstacao-1];
             
             
             // check if our current Node location is the goal Node. If it is, we are done.
             if(current.numEstacao == goal.numEstacao) {
            	 	if (!(caminho.contains(current))) {
            	 		caminho.add(current);
            	 	}
                    imprimirTrajeto();
                    openList.remove(current);
                    closedList.add(current);
                     return 1;
             }
             
           //move current Node to the closed (already searched) list
            openList.remove(current);
            closedList.add(current);
            
          //go through all the current Nodes neighbors and calculate if one should be our next step
            int distanciaMelhorVizinho=1000;
            
            Vertice melhorVizinho=null;
            for(Vertice neighbor : current.retornarVizinhos()) {                    
                System.out.println("Vizinho atual: " + neighbor.numEstacao);    
            	//if we have already searched this Node, don't bother and continue to the next one 
                    if (closedList.contains(neighbor)) {
                    	continue;
                    }
                    
                    int distanciaAtualAteDestino = (custoAteAqui + matrizDistancias[current.numEstacao-1][goal.numEstacao-1]);
                    int distanciaVizinhoAteDestino = (custoAteAqui + matrizDistancias[neighbor.numEstacao-1][goal.numEstacao-1]);
                    
                    if(!openList.contains(neighbor)) {
                        openList.add(neighbor);
                    }	
                    
                   
                    if((distanciaVizinhoAteDestino <= distanciaAtualAteDestino) & (distanciaVizinhoAteDestino <= distanciaMelhorVizinho)) {
                    	System.out.println("Check.");
                    	melhorVizinho = neighbor;
                    	distanciaMelhorVizinho=distanciaVizinhoAteDestino;
                        System.out.println("Vizinho vantagem: " + neighbor.numEstacao);
                    	   	
                    } else {
                    	System.out.println("Vizinho pior: " + neighbor.numEstacao);
                    	openList.remove(neighbor);
                    	closedList.add(neighbor);
                    }
            }
            caminho.add(melhorVizinho);
            /*if (current.numEstacao == goal.numEstacao) {
            	 System.out.println("num estacao current " + current.numEstacao + "num estacao goal " + goal.numEstacao);
         	 	if (!(caminho.contains(current))) {
         	 		caminho.add(current);
         	 	}
                 imprimirTrajeto();
                 openList.remove(current);
                 closedList.add(current);
                  return 1;
            }*/
            System.out.println("current: " + current.numEstacao + ". goal: " + goal.numEstacao);

         }
         
         //imprimirTrajeto();
         return 0;
	}
	
	
	/**
	 * Função simplificada e provisória para mostrar o trajeto escolhido. 
	 * 
	 */
	public void imprimirTrajeto() {
		System.out.println("Caminho: ");
		for (int i=0; i<caminho.size(); i++) {
			System.out.print(caminho.get(i).numEstacao + " ");
		}
	}
	
	 private int/*Path*/ reconstructPath(Vertice node) {
         /*Path path = new Path();
         while(!(node.getPreviousNode() == null)) {
                 path.prependWayPoint(node);
                 node = node.getPreviousNode();
         }
         this.shortestPath = path;
         return path;*/
		 return -1;
	 }
	
	 
	 
	/**
	 * 
	 * @author yvesbastos
	 *
	 */
	private class SortedNodeList {

        private ArrayList<Vertice> list = new ArrayList<Vertice>();

        public Vertice getClosest(Vertice goal) {
        	int distancia=1000;
        	int tIndex=-1;
        	
        	for (int i=0; i<list.size(); i++) {
        		//System.out.println("index: " + list.get(i).numEstacao);
        		int tempDist = matrizDistancias[list.get(i).numEstacao-1][goal.numEstacao-1]; 
        		if (tempDist<distancia) {
        			distancia = tempDist;
        			tIndex=i;
        		}
        	}
                return list.get(tIndex);
        }

        public void clear() {
                list.clear();
        }

        public void add(Vertice node) {
                list.add(node);
        }

        public void remove(Vertice n) {
                list.remove(n);
        }

        public int size() {
                return list.size();
        }

        public boolean contains(Vertice n) {
                return list.contains(n);
        }
}
}

/*private Vertice reconstruct_path(ArrayList<Vertice>came_from, Vertice current_node) {
Vertice p;

if (came_from.contains(current_node)) {
	
	p = reconstruct_path(came_from, came_from.get(came_from.indexOf(current_node)));
	return (p + current_node);
} else return current_node;
}

private int getLowestFScore(int[] f_score) {
int menor=1000;
int indice=0;

for (int i=0; i<f_score.length; i++) {
	if (f_score[i]<menor) {
		menor=f_score[i];
		indice=i;
	}
}
return indice;
}

private int heuristic_cost_estimate(Vertice start, Vertice goal) {
return matrizDistancias[start.numEstacao][goal.numEstacao];
}*/
