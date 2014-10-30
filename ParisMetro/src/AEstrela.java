import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class AEstrela {
	int [][] distancias = new int [14][14];
	BufferedReader fr;
	String line;
	String[] splittedLine;
	private int [] [] matrizDistancias;
	
	public AEstrela() {
		matrizDistancias = new int [14][14];
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
		mostrarMatriz();
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
