import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class AEstrela {
	int [][] distancias = new int [14][14];
	BufferedReader fr;
	String line;
	String[] splittedLine;
	private int [] [] matrizDistancias;
	private ArrayList<Vertice> caminho;
	
	public AEstrela(String caminhoArquivo) {
		caminho = new ArrayList<Vertice>();
		
		matrizDistancias = new int [14][14];
		definirDistancias(caminhoArquivo);
	}
	
	/*
	 * vInicial: vértice inicial
	 * vFinal: vértice final
	 */
	public void calcularTrajeto(Vertice vInicial, Vertice vFinal) {
		//Algoritmo A*
		
		//proximoPasso();
		
		//imprimirTrajeto();
	}
	
	public Vertice proximoPasso(int menorDistancia, Vertice vAtual, Vertice vFinal) {
		//A* prox passo
		return null; //provisorio
	}
	
	public void imprimirTrajeto() {
		System.out.println("Caminho: ");
		for (int i=0; i<caminho.size(); i++) {
			System.out.print(caminho.get(i).numEstacao + " ");
		}
	}
	
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
