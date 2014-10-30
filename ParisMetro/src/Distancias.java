import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Distancias {
	private int [][] distancias = new int [14][14];
	private BufferedReader fr;
	private String line;
	private String[] splittedLine;
	private float [] [] matrizDistancias;

	public Distancias() {
		matrizDistancias = new float [14][14];
	}
	
	/**
	 * Função que lê do arquivo de texto na pasta /data as distâncias entre as estações e coloca na matriz.
	 * @param caminhoArquivo caminho até o .txt
	 */
	public float[][] definirDistancias(String caminhoArquivo) {
		try {
			fr = new BufferedReader(new FileReader(caminhoArquivo));
			//preparado manualmente para arquivo de entrada com 14 linhas; não está ajustando automaticamente
			int j=0;
			
			while (j<14) {
				line = fr.readLine();
				splittedLine = line.split(" ");
				
				for (int i=0; i<splittedLine.length; i++) {
					matrizDistancias[j][i] = Float.parseFloat(splittedLine[i])/30;
				}
				
				j++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		//mostrarMatriz();
		return matrizDistancias;
		
	}
	
	/**
	 * 
	 */
	
	
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
