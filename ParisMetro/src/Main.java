
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AEstrela a = new AEstrela("data/distancias.txt");
		ParisMetro paris = new ParisMetro();
		
		//System.out.println(a.existeBaldeacao(paris.e1, paris.e11));
		
		a.aEstrela(paris.e14, paris.e10);
		
		
	}

}
