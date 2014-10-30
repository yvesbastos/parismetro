import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author yvesbastos
 *
 */
public class AEstrela {
	int [][] distancias = new int [14][14];
	BufferedReader fr;
	String line;
	String[] splittedLine;
	private int [] [] matrizDistancias;
	private ArrayList<Vertice> caminho;
	
	/**
	 * Construtor. Recebe como parâmetro o caminho do .txt com as distancias entre
	 * estações em forma de matriz.
	 * @param caminhoArquivo
	 */
	public AEstrela(String caminhoArquivo) {
		caminho = new ArrayList<Vertice>();
		
		matrizDistancias = new int [14][14];
		definirDistancias(caminhoArquivo);
	}
	
	/**
	 * Função que recebe a origem, destino e calcula o trajeto. A idéia é adicionar o caminho percorrido
	 * no ArrayList caminho (se alguém tiver uma idéia melhor, muda o método). 
	 * @param vInicial
	 * @param vFinal
	 */
	public void calcularTrajeto(Vertice vInicial, Vertice vFinal) {
		//Algoritmo A*
		
		//proximoPasso();
		
		//imprimirTrajeto();
	}
	
	/**
	 * Função para calcular o próximo passo. 
	 * Provisória. Não sei se é necessária. Parte da implementação do A*.
	 * @param menorDistancia
	 * @param vAtual
	 * @param vFinal
	 * @return
	 */
	public Vertice proximoPasso(int menorDistancia, Vertice vAtual, Vertice vFinal) {
		//A* prox passo
		return null; //provisorio
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
	
	/**
	 * Função que lê do arquivo de texto na pasta /data as distâncias entre as estações e coloca na matriz.
	 * @param caminhoArquivo caminho até o .txt
	 */
	public void definirDistancias(String caminhoArquivo) {
		try {
			fr = new BufferedReader(new FileReader(caminhoArquivo));
			//preparado manualmente para arquivo de entrada com 14 linhas; não está ajustando automaticamente
			int j=0;
			
			while (j<14) {
				line = fr.readLine();
				splittedLine = line.split(" ");
				
				for (int i=0; i<splittedLine.length; i++) {
					matrizDistancias[j][i] = Integer.parseInt(splittedLine[i]);
				}
				
				j++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		//mostrarMatriz();
	}
	
	/**
	 * Função para exibir a matriz interpretada
	 */
	public void mostrarMatriz() {
		//preparado manualmente para arquivo de entrada com 14 linhas; não está ajustando automaticamente
		for (int j=0; j<14; j++) {
			System.out.println("\nLinha " + j + ": ");
			for (int i=0; i<14; i++) {
				System.out.print(matrizDistancias[j][i] + " ");
			}
		}
	}
}
